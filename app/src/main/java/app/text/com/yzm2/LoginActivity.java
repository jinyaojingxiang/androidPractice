package app.text.com.yzm2;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SJL1995 on 2016/8/2.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private EditText etUser;
    private EditText etPass;
    private Button btnLogin;
    UserInfo user;
    private Context mContext;
    private RelativeLayout btn_back;
    private Button btnRegister;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x003:
                    JSONObject jsonObject =(JSONObject)msg.obj;
                    try {
                        String status=jsonObject.getString("status");
                        if(status.equals("status")){
                            JSONObject dataObject = jsonObject.getJSONObject("data");
                            String id = dataObject.getString("id");
                            Log.e("id is ", id);
                            user.setUserId(id);
                            user.writeData(mContext);
                            Toast.makeText(LoginActivity.this, "登陆成功，正在跳转主界面！", Toast.LENGTH_SHORT).show();
                            IntentUtils.getIntent(LoginActivity.this, MainActivity.class);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "密码错误！请重试！", Toast.LENGTH_SHORT).show();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(LoginActivity.this, "登录失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext=this;
        etUser=(EditText)findViewById(R.id.et_login_user);
        etPass=(EditText)findViewById(R.id.et_login_pass);
        btnLogin=(Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btn_back=(RelativeLayout)findViewById(R.id.btn_back);
        btnRegister=(Button)findViewById(R.id.btn_login_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                if(NetUtil.isConnnected(this)){
                    String phoNum=etUser.getText().toString();
                    String password=etPass.getText().toString();
                    new Request(this,handler).Login(phoNum,password);
                }else {
                    Toast.makeText(this, "请检查网络！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_login_register:
                IntentUtils.getIntent(this, RegisterActivity.class);
                break;

        }

    }
}

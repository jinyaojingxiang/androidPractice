package app.text.com.yzm2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class RegisterActivity extends Activity implements View.OnClickListener {
    private RelativeLayout btnBack;

    private EditText etPhone,etCode,etpassword;

    private Button btnRegister;
    private Button btnGet;
    private Context context;
    private Button btnLogin;

    private String code;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:
                    JSONObject jsonObject=(JSONObject)msg.obj;

                    try {
                        String status = jsonObject.getString("status");
                        String data = jsonObject.getString("data");
                        JSONObject joCode = new JSONObject(data);
                        code = joCode.getString("code");
                        Log.e("code is ", code);
                        if (status.equals("success")){
                            Toast.makeText(context, "验证码发送成功！", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context,jsonObject.getString("data"),Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0x002:
                    JSONObject registerObj = (JSONObject) msg.obj;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhone=(EditText)findViewById(R.id.et_phone);
        etCode = (EditText)findViewById(R.id.et_register_code_id);
        etpassword=(EditText)findViewById(R.id.et_password);
        btnRegister=(Button)findViewById(R.id.btn_register);
        btnGet=(Button)findViewById(R.id.btn_get);
        btnBack=(RelativeLayout)findViewById(R.id.btn_back);
        btnLogin=(Button)findViewById(R.id.btn_register_login);

        btnGet.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        context=this;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_get:
                new Request(this,handler).SendMobileCode(etPhone.getText().toString());
                break;
            case R.id.btn_back:
                IntentUtils.getIntent(this, Main_frag_activity.class);
                break;
            case R.id.btn_register:
                register();
                break;
            case R.id.btn_register_login:
                IntentUtils.getIntent(this, LoginActivity.class);
                break;
        }
    }

    private void register() {
        String verifyCode = etCode.getText().toString();
        String userPassword=etpassword.getText().toString();
        String phone=etPhone.getText().toString();

        if(verifyCode.equals(code)){
            if (userPassword.length() != 0) {
                new Request(this,handler).Register("小明",phone,userPassword,verifyCode);
                IntentUtils.getIntent(this, MainActivity.class);
                finish();
            }else{
                Toast.makeText(context,"密码不能为空",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(context,"请输入正确的验证码",Toast.LENGTH_LONG).show();
        }
    }


}

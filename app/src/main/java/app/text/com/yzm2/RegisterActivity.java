package app.text.com.yzm2;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout btnBack;

    private EditText editText;

    private Button btnRegister;
    private Button btnGet;
    private Context context;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:
                    JSONObject jsonObject=(JSONObject)msg.obj;
                    try {
                        String status = jsonObject.getString("status");
                        if (status.equals("success")){
                            Toast.makeText(context, "恭喜你，成功了", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context,jsonObject.getString("data"),Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.et_phone);
        btnGet=(Button)findViewById(R.id.btn_get);
        btnBack=(RelativeLayout)findViewById(R.id.btn_back);
        btnGet.setOnClickListener(this);
        context=this;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_get:
                new Request(this,handler).SendMobileCode(editText.getText().toString());
                break;
        }
    }
}

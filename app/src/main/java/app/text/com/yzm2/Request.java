package app.text.com.yzm2;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SJL1995 on 2016/8/1.
 */
public class Request {
    private Context mContext;
    private Handler handler;

    public Request(Context context,Handler handler){
        this.mContext=context;
        this.handler=handler;
    }

    public void SendMobileCode(final String phone){
        new Thread(){
            @Override
            public void run() {
                Message msg = Message.obtain();
                super.run();
                String data="&phone"+phone;
                Log.e("phone=", phone);
                String resultDate= NetUtil.getResponse("http://hq.xiaocool.net/index.php?" +
                        "g=apps&m=index&a=SendMobileCode",data);
                Log.e("result_data=",resultDate);

                try {
                    JSONObject json = new JSONObject(resultDate);
                    msg.what=0x001;
                    msg.obj=json;
                } catch (JSONException e) {
                    e.printStackTrace();
                }finally {
                    handler.sendMessage(msg);
                }


            }
        }.start();

    }
}

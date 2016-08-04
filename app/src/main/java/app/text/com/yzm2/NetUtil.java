package app.text.com.yzm2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SJL on 2016/8/3.
 */
public class NetUtil {

        private static final String TAG = "Nettest";
        /*
        * 网络连接是否可用
        *
        * */
        public static boolean isConnnected(Context context){
            ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if(null!=connectivityManager){
                NetworkInfo networkInfo[]=connectivityManager.getAllNetworkInfo();
                if(null!=networkInfo){
                    for(NetworkInfo info:networkInfo){
                        if(info.getState()==NetworkInfo.State.CONNECTED){
                            return false;
                        }
                    }
                }
                ;
            }
            return false;
        }
        private static String getStringFormInputStream(InputStream is) throws IOException {
            ByteArrayOutputStream os=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len=-1;
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            is.close();
            String state=os.toString();
            os.close();
            return state;
        }

        public static String getResponse(String url,String data){
            String result="";
            HttpURLConnection conn=null;
            try{
                URL mURL=new URL(url);
                conn=(HttpURLConnection)mURL.openConnection();
                conn.setRequestMethod("post");
                conn.setReadTimeout(5000);
                conn.setConnectTimeout(10000);
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setUseCaches(false);

                OutputStream out =conn.getOutputStream();
                out.write(data.getBytes());
                out.flush();
                out.close();

                int responseCode =conn.getResponseCode();
                if(responseCode==200){
                    InputStream is=conn.getInputStream();
                    result=getStringFormInputStream(is);
                    return result;
                }else
                    return result="请求失败，请检查网络";
            }catch (Exception e) {
                return result = "请求失败，请检查网络";//+e.getMessage().toString()
            }
        }

    }

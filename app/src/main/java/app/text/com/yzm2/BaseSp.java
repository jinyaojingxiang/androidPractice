package app.text.com.yzm2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mac on 16/5/24.
 */
public abstract class BaseSp<T> {
    private Context context;
    private SharedPreferences sharedPreferences;
    private String spName;

    //构造方法
    public BaseSp(Context context, String spName) {
        this.context = context;
        this.spName = spName;
        this.sharedPreferences = null;
    }

    //单例模式
    public SharedPreferences getSP() {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(spName, Activity.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public abstract T read() throws Exception;

    public abstract void read(T bean) throws Exception;

    public abstract void write(T bean) throws Exception;

    public abstract void clear();
}

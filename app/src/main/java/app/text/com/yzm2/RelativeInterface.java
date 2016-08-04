package app.text.com.yzm2;

import android.content.Intent;

/**
 * Created by SJL on 2016/8/2.
 */
public interface RelativeInterface {
    void registerRadio(String[] actions);
    void destroyRadio();
    void dealWithRadio(Intent intent);
}

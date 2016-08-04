package app.text.com.yzm2;

import android.app.Fragment;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.widget.RelativeLayout;

/**
 * Created by SJL on 2016/8/2.
 */
public class BaseActivity extends FragmentActivity implements RelativeInterface{

    private IntentFilter myIntentFiler;
    GestureDetector mGestureDetector;
    private boolean needBackGesture=false;
    @Override
    public void registerRadio(String[] actions) {

    }

    @Override
    public void destroyRadio() {

    }

    @Override
    public void dealWithRadio(Intent intent) {

    }
}

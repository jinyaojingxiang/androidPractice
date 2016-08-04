package app.text.com.yzm2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by wzh on 2016/4/29.
 */
public class IntentUtils {

    public static Intent getIntent(Activity activity, Class clazz) {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
        return intent;
    }

    public static Intent getIntents(Context mContext, Class<?> clazz) {
        Intent intent = new Intent(mContext, clazz);
        mContext.startActivity(intent);
        return intent;
    }


}

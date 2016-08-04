package app.text.com.yzm2;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;

/**
 * Created by mac on 16/5/24.
 */
public class UserSp extends BaseSp<UserInfo> {
    public UserSp(Context context) {
        super(context, "user_sp");
    }

    @Override
    public void read(UserInfo user) {
        // 安全检查
        if (user == null) {
            user = new UserInfo();
        }
        if (getSP().contains("userId")) {
            user.setUserId(getSP().getString("userId", ""));
        }
        if (getSP().contains("userIdTemp")) {
            user.setUserIdTemp(getSP().getString("userIdTemp", ""));
        }
        if (getSP().contains("userPhone")) {
            user.setUserPhone(getSP().getString("userPhone", ""));
        }
        if (getSP().contains("userCode")) {
            user.setUserCode(getSP().getString("userCode", ""));
        }
        if (getSP().contains("userName")) {
            user.setUserName(getSP().getString("userName", ""));
        }
        if (getSP().contains("userPassword")) {
            user.setUserPassword(getSP().getString("userPassword", ""));
        }

        if (getSP().contains("userImg")) {
            user.setUserImg(getSP().getString("userImg", ""));
        }
        if (getSP().contains("userSex")) {
            user.setUserSex(getSP().getString("userSex", ""));
        }
        if (getSP().contains("userAddr")) {
            user.setuserAddr(getSP().getString("userAddr", ""));
        }
        if (getSP().contains("Currentcar")) {
            user.setCurrentcar(getSP().getString("Currentcar", ""));
        }
        if (getSP().contains("userBranch")) {
            user.setUserBranch(getSP().getString("userBranch", ""));
        }
        if(getSP().contains("userCurrentCarId")){
            user.setUserCurrentCarId(getSP().getString("userCurrentCarId",""));
        }
//        private String userCurrentCarBrand;
//        private String userCurrentCarType;
//        private String userCurrentCarEnginenumber;
        if(getSP().contains("userCurrentCarBrand")){
            user.setUserCurrentCarBrand(getSP().getString("userCurrentCarBrand",""));
        }
        if(getSP().contains("userCurrentCarType")){
            user.setUserCurrentCarType(getSP().getString("userCurrentCarType",""));
        }
        if(getSP().contains("userCurrentCarEnginenumber")){
            user.setUserCurrentCarEnginenumber(getSP().getString("userCurrentCarEnginenumber",""));
        }
        if(getSP().contains("usershopId")){
            user.SetshopId(getSP().getStringSet("usershopId", new HashSet()));
//            Log.e("usershopId is",getSP().getStringSet("usershId",new HashSet<String>()).toString());
        }
    }

    @Override
    public UserInfo read() {
        UserInfo result = null;
        result = new UserInfo();
        read(result);
        return result;
    }

    @Override
    public void write(UserInfo user) {
        SharedPreferences.Editor editor = getSP().edit();
        if (!user.getUserId().equals("")) {
            editor.putString("userId", user.getUserId());
        }
        if (!user.getUserIdTemp().equals("")) {
            editor.putString("userIdTemp", user.getUserIdTemp());
        }
        if (!user.getUserPhone().equals("")) {
            editor.putString("userPhone", user.getUserPhone());
        }
        if (!user.getUserPhone().equals("")) {
            editor.putString("userCode", user.getUserCode());
        }
        if (!user.getUserName().equals("")) {
            editor.putString("userName", user.getUserName());
        }
        if (!user.getUserPassword().equals("")) {
            editor.putString("userPassword", user.getUserPassword());
        }

        if (!user.getUserImg().equals("")) {
            editor.putString("userImg", user.getUserImg());
        }
        if (!user.getUserSex().equals("")) {
            editor.putString("userSex", user.getUserSex());
        }
        if (!user.getUserAddr().equals("")) {
            editor.putString("userAddr", user.getUserAddr());
        }
        if (!user.getCurrentcar().equals("")) {
            editor.putString("Currentcar", user.getCurrentcar());
        }
        if (!user.getUserBranch().equals("")) {
            editor.putString("userBranch", user.getUserBranch());
        }
        if(!user.getUserCurrentCarId().equals("")){
            editor.putString("userCurrentCarId",user.getUserCurrentCarId());
        }
        if(!user.getUserCurrentCarBrand().equals("")){
            editor.putString("userCurrentCarBrand",user.getUserCurrentCarBrand());
        }
        if(!user.getUserCurrentCarType().equals("")){
            editor.putString("userCurrentCarType",user.getUserCurrentCarType());
        }
        if(!user.getUserCurrentCarEnginenumber().equals("")){
            editor.putString("userCurrentCarEnginenumber",user.getUserCurrentCarEnginenumber());
        }
        if(!user.getshopId().isEmpty()){
            editor.putStringSet("usershopId",user.getshopId());
        }
        editor.commit();
    }

    @Override
    public void clear() {
        SharedPreferences.Editor editor = getSP().edit();
        editor.clear();
        editor.commit();
    }
}

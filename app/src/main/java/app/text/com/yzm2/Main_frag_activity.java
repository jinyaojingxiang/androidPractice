package app.text.com.yzm2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import fragment.Dongtai_fragment;
import fragment.Home_fragment;
import fragment.Message_fragment;
import fragment.Mine_fragment;

/**
 * Created by SJL on 2016/8/4.
 */
public class Main_frag_activity extends Activity implements View.OnClickListener {
    private Home_fragment homeFragment;
    private Dongtai_fragment dongtaiFragment;
    private Message_fragment messageFragment;
    private Mine_fragment mineFragment;

    private View homeView;
    private View dongtaiView;
    private View messageView;
    private View mineView;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        initView();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_home:
                setTabSelection(0);
                break;
            case R.id.rl_msg:
                setTabSelection(1);
                break;
            case R.id.rl_dong:
                setTabSelection(2);
                break;
            case R.id.rl_mine:
                setTabSelection(3);
                break;
        }

    }
    private void setTabSelection(int index) {
        clearSelection();
        FragmentTransaction transation = fragmentManager.beginTransaction();
        hideFragments(transation);
        switch (index){
            case 0:
                homeView.setBackgroundColor(0xff91dae9);
                if(homeFragment==null){
                    homeFragment= new Home_fragment();
                    transation.add(R.id.frame,homeFragment);
                }else
                    transation.show(homeFragment);
            case 1:
                messageView.setBackgroundColor(0xff91dae9);
                if(messageFragment==null){
                    messageFragment= new Message_fragment();
                    transation.add(R.id.frame,messageFragment);
                }else
                    transation.show(messageFragment);
            case 2:
                dongtaiView.setBackgroundColor(0xff91dae9);
                if(dongtaiFragment==null){
                    dongtaiFragment= new Dongtai_fragment();
                    transation.add(R.id.frame,dongtaiFragment);
                }else
                    transation.show(dongtaiFragment);
            case 3:
                mineView.setBackgroundColor(0xff91dae9);
                if(mineFragment==null){
                    mineFragment= new Mine_fragment();
                    transation.add(R.id.frame,mineFragment);
                }else
                    transation.show(mineFragment);
        }
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (dongtaiFragment != null) {
            transaction.hide(dongtaiFragment);
        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    private void initView() {
        homeView = findViewById(R.id.rl_home);
        dongtaiView = findViewById(R.id.rl_dong);
        messageView = findViewById(R.id.rl_msg);
        mineView = findViewById(R.id.rl_mine);

        homeView.setOnClickListener(this);
        dongtaiView.setOnClickListener(this);
        messageView.setOnClickListener(this);
        mineView.setOnClickListener(this);
    }

    private void clearSelection() {
        homeView.setBackgroundColor(0xffffffff);
        dongtaiView.setBackgroundColor(0xffffffff);
        messageView.setBackgroundColor(0xffffffff);
        mineView.setBackgroundColor(0xffffffff);
    }
}

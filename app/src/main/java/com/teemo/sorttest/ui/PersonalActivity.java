package com.teemo.sorttest.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.teemo.sorttest.R;
import com.teemo.sorttest.fragment.NameFragment;
import com.teemo.sorttest.fragment.PersonalListFragment;
import com.teemo.sorttest.fragment.PhotoFragment;

public class PersonalActivity extends AppCompatActivity implements PersonalListFragment.OnFragmentInteractionListener {

    private static String TAG_FRoot = "TAG_FRoot";
    private static String TAG_FName = "TAG_FName";
    private static String TAG_FPhoto = "TAG_FPhoto";

    private FragmentManager manager;

    /**
     * 根Fragment
     */
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        manager = getSupportFragmentManager();

        // 这里一定要在save为null时才加载Fragment，Fragment中onCreateView等生命周里加载根子Fragment同理
        // 因为在页面重启时，Fragment会被保存恢复，而此时再加载Fragment会重复加载，导致重叠
        if (savedInstanceState == null) {
            // 正常情况下去 加载根Fragment
            mContent = new PersonalListFragment();
            manager.beginTransaction()
                    .add(R.id.container, mContent, TAG_FRoot)
                    .commit();
        } else {
            mContent = manager.findFragmentByTag(TAG_FRoot);
        }
    }

    /**
     * fragment 切换
     *
     * @param from .
     * @param to   .
     */
    private void switchFragment(Fragment from, Fragment to, String tag) {
        if (from == to) return;
        if (mContent != to) {
            mContent = to;

            if (!to.isAdded()) { // 先判断是否被add过
                manager.beginTransaction().add(R.id.container, to, tag)
                        .addToBackStack(to.getClass().getSimpleName())
                        .hide(from).show(to)
                        .commit();
                Log.e("TAG", "未添加" + to.getClass().getSimpleName());
            } else {
                manager.beginTransaction().hide(from).show(to).commit();
                Log.e("TAG", "已添加" + to.getClass().getSimpleName());
            }
        }
    }

    @Override
    public void onFragmentInteraction(int index) {
        switch (index) {
            case R.id.l_name:
                Fragment nameFragment = manager.findFragmentByTag(TAG_FName);
                switchFragment(mContent, nameFragment == null ? new NameFragment() : nameFragment, TAG_FName);
                break;
            case R.id.l_photo:
                Fragment photoFragment = manager.findFragmentByTag(TAG_FPhoto);
                switchFragment(mContent, photoFragment == null ? new PhotoFragment() : photoFragment, TAG_FPhoto);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mContent = manager.findFragmentById(R.id.container);
        Snackbar.make(getWindow().getDecorView(),"aj:"+mContent.getTag(),Snackbar.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_list:
                Fragment listFragment = manager.findFragmentByTag(TAG_FRoot);
                switchFragment(mContent, listFragment == null ? new PersonalListFragment() : listFragment, TAG_FRoot);
                break;
            case R.id.btn_name:
                Fragment nameFragment = manager.findFragmentByTag(TAG_FName);
                switchFragment(mContent, nameFragment == null ? new NameFragment() : nameFragment, TAG_FName);
                break;
            case R.id.btn_photo:
                Fragment photoFragment = manager.findFragmentByTag(TAG_FPhoto);
                switchFragment(mContent, photoFragment == null ? new PhotoFragment() : photoFragment, TAG_FPhoto);
                break;

        }
    }


}

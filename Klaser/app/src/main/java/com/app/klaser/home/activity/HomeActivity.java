package com.app.klaser.home.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.app.klaser.R;
import com.app.klaser.add.fragment.AddFragment;
import com.app.klaser.base.BaseFragment;
import com.app.klaser.home.fragment.HomeFragment;
import com.app.klaser.message.fragment.MessageFragment;
import com.app.klaser.search.fragment.SearchFragment;
import com.app.klaser.user.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页
 */
public class HomeActivity extends FragmentActivity {
    /**
     * 分别装载ViewPager主页，搜索，添加，消息,我五个Fragment
     */
    private static List<BaseFragment> sFragments;
    /**
     * 标题栏的字符标题的ID
     */
    private static final int[] STITLE_IDS = new int[]
            {R.string.activity_main_bottom_tab_home,
                    R.string.activity_main_bottom_tab_search,
                    R.string.activity_main_bottom_tab_add,
                    R.string.activity_main_bottom_tab_message,
                    R.string.activity_main_bottom_tab_search};
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.bottom_tab_radiogroup)
    RadioGroup mBottomTabRadioGroup;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.title_bar_textView)
    TextView mtitleTextView;
    private int position;
    // 缓存的Fragment或者说是上次界面
    private Fragment tempFragemnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        initListener();
    }

    /**
     * 添加的时候要按照顺序添加
     */
    private void initFragment() {
        sFragments= new ArrayList<>();
        sFragments.add(new HomeFragment());
        sFragments.add(new SearchFragment());
        sFragments.add(new AddFragment());
        sFragments.add(new MessageFragment());
        sFragments.add(new UserFragment());
    }


    private void initListener() {
        mBottomTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.e("zrq", "i:"+i);
                switch (i) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_search:
                        position = 1;
                        break;
                    case R.id.rb_add:
                        position = 2;
                        break;
                    case R.id.rb_message:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;
                    default:
                        position = 0;
                        break;
                }
                mtitleTextView.setText(STITLE_IDS[position]);
                //根据位置取不同的Fragment
                BaseFragment baseFragment = getFragment(position);
                // 第一个参数：上次显示的Fragment // 第二个参数：当前证要显示的Fragment
                switchFragment(tempFragemnt, baseFragment);
            }
        });
        mBottomTabRadioGroup.check(R.id.rb_home);
    }

    private BaseFragment getFragment(int position) {
        if (sFragments != null && sFragments.size() > 0) {
            Log.e("TAG", "getFragment: 执行了");
            return sFragments.get(position);
        }
        return null;

    }

    /**
     * 切换Fragment
     *
     * @param fromFragment
     * @param nextFragment
     */
    private void switchFragment(Fragment fromFragment, BaseFragment
            nextFragment) {
        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //判断 nextFragment 是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

}

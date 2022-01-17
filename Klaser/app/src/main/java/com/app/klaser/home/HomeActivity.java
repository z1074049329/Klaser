package com.app.klaser.home;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.klaser.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeActivity extends FragmentActivity {
    private static final String TAG = HomeActivity.class.getName();
    /**分别装载ViewPager主页，搜索，添加，消息,我五个Fragment*/
    private static List<Fragment> sFragments=new ArrayList<Fragment>(5);
    /**标题栏的字符标题的ID*/
    private static final int[] STITLE_IDS =new int[]
            {R.string.activity_main_bottom_tab_home,
                    R.string.activity_main_bottom_tab_search,
                    R.string.activity_main_bottom_tab_add,
                    R.string.activity_main_bottom_tab_message,
                    R.string.activity_main_bottom_tab_search};
    private RadioGroup mBottomTabRadioGroup;
    private ViewPager mViewPager;
    private TextView mtitleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        mtitleTextView=(TextView)findViewById(R.id.title_bar_textView);
        mBottomTabRadioGroup=(RadioGroup)findViewById(R.id.bottom_tab_radiogroup);
        sFragments.add(new Fragment());
        sFragments.add(new Fragment());
        sFragments.add(new Fragment());
        sFragments.add(new Fragment());
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position)
            {
                return sFragments.get(position);
            }
            @Override
            public int getCount()
            {
                return sFragments.size();
            }
        });

        /**监听页面的滑动，以改变标题栏的标题*/
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
            }
            @Override
            public void onPageSelected(int position)
            {
                mtitleTextView.setText(STITLE_IDS[position]);
                ((RadioButton)mBottomTabRadioGroup.getChildAt(position)).setChecked(true);
            }
            @Override
            public void onPageScrollStateChanged(int state)
            {
            }
        });
//        HttpClientUtils.postText(this,"hafhla");
    }
    /**
     * 监听底部导航栏那个选项被点击，以改变标题栏的标题
     */
    public void onClick(View view)
    {
        int id=mBottomTabRadioGroup.indexOfChild(view);
        mtitleTextView.setText(STITLE_IDS[id]);
    }
}

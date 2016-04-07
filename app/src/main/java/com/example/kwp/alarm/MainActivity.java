package com.example.kwp.alarm;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwp.view.ViewPagerIndicator;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends FragmentActivity {


    private ViewPager mViewPager;
    private ViewPagerIndicator mIndicator;
    private List<String> mTitles = Arrays.asList("闹钟","小工具","设置");
    private  List<VpFragment> mContents = new ArrayList<VpFragment>();
    private FragmentPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        initViews();
        initDates();
        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.scroll(position, positionOffset);

            }

            @Override
            public void onPageSelected(int position) {
                highLightTextView(position);
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

    }


    private void initDates() {
        for(String title:mTitles){
            VpFragment fragment = VpFragment.newInstance(title);
            mContents.add(fragment);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {


            @Override
            public int getCount() {
                return mContents.size();
            }
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mContents.get(position);
            }
        };
    }

    private void initViews() {
        mViewPager =(ViewPager) findViewById(R.id.id_viewpager);
        mIndicator = (ViewPagerIndicator)findViewById(R.id.id_indicator);
    }

    private void resetTextViewColor(){
        for (int i =0;i<mIndicator.getChildCount();++i){
            View view = mIndicator.getChildAt(i);
            if(view instanceof TextView){
                ((TextView) view).setTextColor(0x64FFFFFF);
            }
        }
    }

    private void highLightTextView(int pos){
        resetTextViewColor();
        View view = mIndicator.getChildAt(pos);
        if(view instanceof TextView){
            ((TextView) view).setTextColor(0xCCFFFFFF);
            TextPaint tp =  ((TextView) view).getPaint();
            tp.setFakeBoldText(true);


        }
    }

}
package com.example.kwp.alarm;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by kwp on 2016/4/7.
 */
public class VpFragment extends android.support.v4.app.Fragment {
    private String mTitle;
    public static String BUNDLE_TLTLE = "title";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        ListView listView = new ListView(getActivity());
        if(bundle!=null){
            mTitle = bundle.getString(BUNDLE_TLTLE);
        }
        TextView tv = new TextView(getActivity());
        tv.setTextColor(Color.BLACK);
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);
        return tv;

    }

    public static VpFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TLTLE, title);
        VpFragment fragment = new VpFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

}

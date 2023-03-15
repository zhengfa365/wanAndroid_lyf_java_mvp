package com.example.lib.core.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragmentList;

    public SimpleFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    public void setFragmentList(Fragment... fragmentList){
        this.fragmentList=fragmentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList[position];
    }

    @Override
    public int getCount() {
        return fragmentList==null?0:fragmentList.length;
    }
}

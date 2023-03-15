package com.example.lib.core.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class TabFragmentPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    private Page[] mPages;
    private ViewPager mViewPager;
    private LinearLayout mTabContainer;
    private int mTabItemRes;

    public TabFragmentPagerAdapter(@NonNull FragmentManager fm, ViewPager viewPager, LinearLayout tabContainer, int tabItemRes) {
        super(fm);
        this.mViewPager = viewPager;
        this.mTabContainer = tabContainer;
        this.mTabItemRes = tabItemRes;
        viewPager.setAdapter(this);

    }

    public void setPages(Page... pages) {
        mViewPager.setOffscreenPageLimit(pages.length);
        this.mPages = pages;
        mTabContainer.removeAllViews();
        for (Page page : mPages) {
            initPageTab(page);
        }
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        int curPos = mViewPager.getCurrentItem();
        for (int i = 0; i < mPages.length; i++) {
            mPages[i].notifyTabItem(curPos == i);
        }

    }

    private void initPageTab(Page page) {
        page.view = LayoutInflater.from(mTabContainer.getContext()).inflate(mTabItemRes, mTabContainer, false);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) page.view.getLayoutParams();
        params.height = LinearLayout.LayoutParams.MATCH_PARENT;
        params.width = 0;
        params.weight = 1;
        mTabContainer.addView(page.view, params);
        mViewPager.setOnPageChangeListener(this);
        page.view.setOnClickListener(view -> { setCurrentPage(page); });
    }

    private void setCurrentPage(Page page) {
        for(int i=0;i<mPages.length;i++){
            if(mPages[i]==page){
                mViewPager.setCurrentItem(i);
            }
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mPages[position].fragment;
    }

    @Override
    public int getCount() {
        return mPages == null ? 0 : mPages.length;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < mPages.length; i++) {
            mPages[i].notifyTabItem(position == i);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public static class Page<T> {
        private Fragment fragment;
        private T data;
        private View view;
        private TabAdapter<T> tabAdapter;

        public Page(Fragment fragment, T data, TabAdapter<T> tabAdapter) {
            this.fragment = fragment;
            this.data = data;
            this.tabAdapter = tabAdapter;
        }

        public void notifyTabItem(boolean isSelect) {
            tabAdapter.bindData(view, data, isSelect);
        }

        public interface TabAdapter<T> {
            void bindData(View view, T data, boolean selected);
        }
    }
}

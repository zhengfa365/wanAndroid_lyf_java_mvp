package com.example.lyfwanandroid.fragment;

import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.lib.core.adapter.TabFragmentPagerAdapter;
import com.example.lib.core.mvp.BaseFragment;
import com.example.lib.core.mvp.MvpPresenter;
import com.example.lyfwanandroid.R;
import com.example.lyfwanandroid.module.home.fragment.HomeFragment;
import com.example.lyfwanandroid.module.knowledge.fragment.KnowledgeFragment;
import com.example.lyfwanandroid.module.main.adapter.HomeTabItemAdapter;
import com.example.lyfwanandroid.module.main.model.TabBean;
import com.example.lyfwanandroid.module.mine.fragment.MineFragment;
import com.example.lyfwanandroid.module.question.fragment.QuestionFragment;

import butterknife.BindView;

public class MainFragment extends BaseFragment {
    @BindView(R.id.vp_tab)
    ViewPager vp_tab;
    @BindView(R.id.ll_bottom_bar)
    LinearLayout ll_bottom_bar;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    protected MvpPresenter initPresenter() {
        return null;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        TabFragmentPagerAdapter tabFragmentPagerAdapter=new TabFragmentPagerAdapter(getChildFragmentManager(),vp_tab,ll_bottom_bar,R.layout.item_home_tab);
        tabFragmentPagerAdapter.setPages(
                new TabFragmentPagerAdapter.Page(new HomeFragment(),new TabBean("首页",R.drawable.ic_bottom_bar_mine),new HomeTabItemAdapter()),
                new TabFragmentPagerAdapter.Page(new KnowledgeFragment(),new TabBean("首页",R.drawable.ic_bottom_bar_mine),new HomeTabItemAdapter()),
                new TabFragmentPagerAdapter.Page(new QuestionFragment(),new TabBean("首页",R.drawable.ic_bottom_bar_mine),new HomeTabItemAdapter()),
                new TabFragmentPagerAdapter.Page(new MineFragment(),new TabBean("首页",R.drawable.ic_bottom_bar_mine),new HomeTabItemAdapter()));


    }
}

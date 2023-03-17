package com.example.lyfwanandroid.module.question.fragment;

import androidx.annotation.NonNull;

import com.example.lib.core.mvp.BaseFragment;
import com.example.lib.core.mvp.MvpPresenter;
import com.example.lyfwanandroid.R;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

public class QuestionFragment extends BaseFragment {
    @BindView(R.id.srl)
    RefreshLayout srl;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_question;
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
        srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
        srl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }
        });
    }
}

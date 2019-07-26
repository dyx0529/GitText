package com.jiyun.dingyaxin.geekdemo.base;

public abstract class BaseMvpFragment<P extends BasePresenter>extends BaseFragment{

    protected P mPresenter;

    @Override
    protected void initPresenter() {
        mPresenter=initMvp();
    }

    protected abstract P initMvp();

	add func3;
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter=null;
    }
}

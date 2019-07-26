package com.jiyun.dingyaxin.mydemo_1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends SimpleActivity{

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter=initPresenter();
        super.onCreate(savedInstanceState);
        if (mPresenter!=null){
            mPresenter.attach((V) this);
        }
    }
    public void showProgressBar(){

    }
    public void hideProgressBar(){

    }
    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}

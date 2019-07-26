package com.jiyun.dingyaxin.mydemo_1.contract;

import com.jiyun.dingyaxin.mydemo_1.bean.ListBean;

import java.util.List;

public interface MainContract {

    //V层
    interface MainView{
        void onSuccess(List<ListBean>beans);
        void onFailed(String error);
    }
    //P层
    interface MainPresenter{
        void update();
    }
    //M层
    interface MainModle{
        //CallBack
        interface CallBack{
            void showSuccess(List<ListBean>beans);
            void showError(String error);
        }

        void getData(CallBack callBack);
    }
}

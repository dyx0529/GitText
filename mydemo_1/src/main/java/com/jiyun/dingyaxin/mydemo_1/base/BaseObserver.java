package com.jiyun.dingyaxin.mydemo_1.base;

import com.jiyun.dingyaxin.mydemo_1.http.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<T> {

    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onNext(T value) {
        onSuccess(value);
    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException){
            ApiException apiException= (ApiException) e;
            int errorCode = apiException.getErrorCode();
            switch (errorCode){
                case 1:
            }
            onErrors(apiException.getErrorMsg());
        }else if (e instanceof HttpException){
            onErrors(e.getMessage());
        }
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }

    @Override
    public void onComplete() {
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }
    abstract <T> void onSuccess(T data);
    abstract <T> void onErrors(T error);
}

package com.jiyun.dingyaxin.mydemo_1.http;

import com.jiyun.dingyaxin.mydemo_1.bean.BaseResponse;
import com.jiyun.dingyaxin.mydemo_1.bean.ListBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyServer {

    @GET
    Observable<BaseResponse<List<ListBean>>>getUrl(@Url String url);
}

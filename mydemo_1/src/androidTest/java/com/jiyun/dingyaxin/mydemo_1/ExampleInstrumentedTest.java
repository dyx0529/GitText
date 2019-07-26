package com.jiyun.dingyaxin.mydemo_1;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.jiyun.dingyaxin.mydemo_1.bean.BaseResponse;
import com.jiyun.dingyaxin.mydemo_1.bean.ListBean;
import com.jiyun.dingyaxin.mydemo_1.http.HttpManager;
import com.jiyun.dingyaxin.mydemo_1.http.MyServer;
import com.jiyun.dingyaxin.mydemo_1.utils.RxUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import io.reactivex.functions.Consumer;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.jiyun.dingyaxin.mydemo_1", appContext.getPackageName());
    }
    @Test
    public void Http(){
        HttpManager.getInstance().getServer(MyServer.class).getUrl("wxarticle/chapters/json")
                .compose(RxUtils.<BaseResponse<List<ListBean>>>rxScheduleThread())
                .compose(RxUtils.<List<ListBean>>changeResult())
                .subscribe(new Consumer<List<ListBean>>() {
                    @Override
                    public void accept(List<ListBean> beans) throws Exception {
                        Log.e("dyx", "accept: "+beans.toString());
                    }
                });
    }
}

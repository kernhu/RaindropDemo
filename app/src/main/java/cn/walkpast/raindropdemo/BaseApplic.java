package cn.walkpast.raindropdemo;

import android.app.Application;

import cn.walkpast.raindrop.RaindropConfig;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author: Kern Hu
 * @emali: create at: 2019/6/3 14:03.
 * modify at: 2019/6/3 14:03.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class BaseApplic extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RaindropConfig
                .getInstance()
                .setContext(this)
                .setConnectTimeout(12)
                .setReadTimeout(12)
                .setWriteTimeout(12)
                .setRetryOnConnectionFailure(true)
                .setLogTag("raindrop-dome-sos")
                .setLogLevel(HttpLoggingInterceptor.Level.BODY)
                .setLogPrintable(BuildConfig.DEBUG)
                .setRetrofitLockable(true)
                .setBaseUrl("")
                .build();
    }
}

package cn.walkpast.raindrop.retroft;

import android.text.TextUtils;

import com.google.gson.GsonBuilder;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import cn.walkpast.raindrop.RaindropConfig;
import cn.walkpast.raindrop.logging.LoggerInterceptor;
import cn.walkpast.raindrop.ssl.RaindropSSLSocketFactory;
import cn.walkpast.raindrop.ssl.RaindropX509TrustManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author: Kern Hu
 * @emali: create at: 2019/6/3 12:45.
 * modify at: 2019/6/3 12:45.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class RaindropFactoryImpl implements RaindropFactory {

    private volatile static Retrofit mRetrofit = null;
    protected Retrofit.Builder mRetrofitBuilder = new Retrofit.Builder();
    protected OkHttpClient.Builder mHttpBuilder = new OkHttpClient.Builder();

    public RaindropFactoryImpl(String hostUrl) {

        if (!TextUtils.isEmpty(RaindropConfig.getInstance().getX509TrustFileName())) {
            mHttpBuilder.sslSocketFactory(RaindropSSLSocketFactory.getSSLSocketFactory(), new RaindropX509TrustManager());
        }

        mRetrofitBuilder
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(hostUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setLenient()
                        .create()
                ))
                .client(mHttpBuilder.addInterceptor(
                        new LoggerInterceptor()
                                .setLogTag(RaindropConfig.getInstance().getLogTag())
                                .setLevel(RaindropConfig.getInstance().getLevel())
                                .setPrintable(RaindropConfig.getInstance().isPrintable())
                                .build()
                        )
                                .readTimeout(RaindropConfig.getInstance().getReadTimeout(), TimeUnit.SECONDS)
                                .connectTimeout(RaindropConfig.getInstance().getConnectTimeout(), TimeUnit.SECONDS)
                                .writeTimeout(RaindropConfig.getInstance().getWriteTimeout(), TimeUnit.SECONDS)
                                .build()
                );
    }

    @Override
    public Retrofit getRetrofit() {
        synchronized (RaindropFactoryImpl.class) {
            if (RaindropConfig.getInstance().isLockable()) {
                if (mRetrofit == null) {
                    mRetrofit = mRetrofitBuilder.build();
                }
            } else {
                mRetrofit = mRetrofitBuilder.build();
            }
        }
        return mRetrofit;
    }

    @Override
    public OkHttpClient.Builder setInterceptor(Interceptor interceptor) {
        return mHttpBuilder.addInterceptor(interceptor);
    }

    @Override
    public Retrofit.Builder setConverterFactory(Converter.Factory factory) {
        return mRetrofitBuilder.addConverterFactory(factory);
    }
}

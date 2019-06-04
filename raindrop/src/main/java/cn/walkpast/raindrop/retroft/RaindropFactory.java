package cn.walkpast.raindrop.retroft;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 11:44.
 * modify at: 2019/6/3 11:44.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public interface RaindropFactory {

    Retrofit getRetrofit();

    OkHttpClient.Builder setInterceptor(Interceptor interceptor);

    Retrofit.Builder setConverterFactory(Converter.Factory factory);

}

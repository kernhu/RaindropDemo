package cn.walkpast.raindrop.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/4 20:26.
 * modify at: 2019/6/4 20:26.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class NetWorkInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        response.request().url();
        request.url();
        return response;
    }
}

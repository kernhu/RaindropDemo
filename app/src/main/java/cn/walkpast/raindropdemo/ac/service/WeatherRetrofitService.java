package cn.walkpast.raindropdemo.ac.service;

import cn.walkpast.raindropdemo.common.CommonResponse;
import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author: Kern Hu
 * @emali: create at: 2019/6/3 15:04.
 * modify at: 2019/6/3 15:04.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public interface WeatherRetrofitService {

    @POST("weatherApi")
    Observable<CommonResponse> submit(@Query("city") String city);
}

package cn.walkpast.raindropdemo.ac.service;

import cn.walkpast.raindrop.retroft.RaindropFactoryImpl;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 15:05.
 * modify at: 2019/6/3 15:05.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class WeatherApi extends RaindropFactoryImpl {


    private static WeatherApi mWeatherApi = new WeatherApi("https://www.apiopen.top/");

    public WeatherApi(String baseUrl) {
        super(baseUrl);
    }

    public static WeatherRetrofitService getInstance() {

        return mWeatherApi.getRetrofit().create(WeatherRetrofitService.class);
    }
}

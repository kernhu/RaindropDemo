package cn.walkpast.raindrop.cookie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/4 20:35.
 * modify at: 2019/6/4 20:35.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class NewCookieJar implements CookieJar {

    private LinkedHashMap<String, List<Cookie>> cookieMap;

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookieMap.put(url.host(), cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookieMap.get(url.host()) == null ? new ArrayList<Cookie>() : cookieMap.get(url.host());
    }
}

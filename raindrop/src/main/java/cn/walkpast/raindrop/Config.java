package cn.walkpast.raindrop;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/4 20:42.
 * modify at: 2019/6/4 20:42.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class Config {

    /**
     * timeout TimeUnit.SECONDS
     */
    public static long readTimeout = 10;

    /**
     * timeout TimeUnit.SECONDS
     */
    public static long connectTimeout = 10;

    /**
     * timeout TimeUnit.SECONDS
     */
    public static long writeTimeout = 10;

    /**
     * retry on connection when request failure
     */
    public static boolean retryOnConnectionFailure = true;

    /**
     *
     */
    public static String sslCertificate = "";

    /**
     * log tag
     */
    public static String logTag = "raindrop_log";
    /**
     * log level
     */
    public static HttpLoggingInterceptor.Level logLevel = HttpLoggingInterceptor.Level.BODY;
    /**
     * whether print log or not
     */
    public static boolean logPrintable = true;

    /**
     * whether retrofit is a singleton or not
     * when your host and host are consistent,please set true,if not please false;
     */
    public static boolean retrofitLockable = true;

    /**
     * base url( host + port)
     */
    public static String baseUrl = "";

}

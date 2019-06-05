package cn.walkpast.raindrop;

import android.content.Context;
import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/3 13:47.
 * modify at: 2019/6/3 13:47.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class RaindropConfig {

    private static RaindropConfig mRaindropConfig;

    private Context context;
    /**
     * timeout TimeUnit.SECONDS
     */
    private long readTimeout = 10;

    /**
     * timeout TimeUnit.SECONDS
     */
    private long connectTimeout = 10;

    /**
     * timeout TimeUnit.SECONDS
     */
    private long writeTimeout = 10;

    /**
     *
     */
    private String sslCertificate;

    /**
     * log tag
     */
    private String logTag = "raindrop_log";
    /**
     * log level
     */
    private HttpLoggingInterceptor.Level logLevel = HttpLoggingInterceptor.Level.BODY;
    /**
     * whether print log or not
     */
    private boolean logPrintable = true;

    /**
     * whether retrofit is a singleton or not
     * when your host and host are consistent,please set true,if not please false;
     */
    private boolean retrofitLockable = true;

    /**
     * base url( host + port)
     */
    private String baseUrl;

    public static RaindropConfig getInstance() {
        if (mRaindropConfig == null) {
            mRaindropConfig = new RaindropConfig();
        }
        return mRaindropConfig;
    }

    public Context getContext() {
        return context;
    }

    public RaindropConfig setContext(Context context) {
        this.context = context;
        return this;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public RaindropConfig setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public RaindropConfig setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public RaindropConfig setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public String getSslCertificate() {
        return sslCertificate;
    }

    public RaindropConfig setSslCertificate(String sslCertificate) {
        this.sslCertificate = sslCertificate;
        return this;
    }

    public String getLogTag() {
        return logTag;
    }

    public RaindropConfig setLogTag(String logTag) {
        this.logTag = logTag;
        return this;
    }

    public HttpLoggingInterceptor.Level getLogLevel() {
        return logLevel;
    }

    public RaindropConfig setLogLevel(HttpLoggingInterceptor.Level logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public boolean isLogPrintable() {
        return logPrintable;
    }

    public RaindropConfig setLogPrintable(boolean logPrintable) {
        this.logPrintable = logPrintable;
        return this;
    }

    public boolean isRetrofitLockable() {
        return retrofitLockable;
    }

    public RaindropConfig setRetrofitLockable(boolean retrofitLockable) {
        this.retrofitLockable = retrofitLockable;
        return this;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public RaindropConfig setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public void build() {

        Config.connectTimeout = getConnectTimeout();
        Config.readTimeout = getReadTimeout();
        Config.writeTimeout = getWriteTimeout();
        Config.baseUrl = getBaseUrl();
        Config.logLevel = getLogLevel();
        Config.logPrintable = isLogPrintable();
        Config.logTag = getLogTag();
        Config.retrofitLockable = isRetrofitLockable();
        Config.sslCertificate = getSslCertificate();

        Log.i("raindrop", "------------------------------------------------------------");
        Log.i("raindrop", "----------------- raindrop config success ------------------");
        Log.i("raindrop", "------------------------------------------------------------");

    }
}

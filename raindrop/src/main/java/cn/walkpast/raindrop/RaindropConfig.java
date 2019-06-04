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
    private String x509TrustFileName;

    /**
     * log tag
     */
    private String logTag = "raindrop_log";
    /**
     * log level
     */
    private HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
    /**
     * whether print log or not
     */
    private boolean printable = true;

    /**
     * whether retrofit is a singleton or not
     * when your host and host are consistent,please set true,if not please false;
     */
    private boolean lockable = true;

    /**
     * the result code
     */
    private int apiCode;
    /**
     * the result message
     */
    private String apiMessage;

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

    public String getX509TrustFileName() {
        return x509TrustFileName;
    }

    public RaindropConfig setX509TrustFileName(String x509TrustFileName) {
        this.x509TrustFileName = x509TrustFileName;
        return this;
    }

    public String getLogTag() {
        return logTag;
    }

    public RaindropConfig setLogTag(String logTag) {
        this.logTag = logTag;
        return this;
    }

    public HttpLoggingInterceptor.Level getLevel() {
        return level;
    }

    public RaindropConfig setLevel(HttpLoggingInterceptor.Level level) {
        this.level = level;
        return this;
    }

    public boolean isPrintable() {
        return printable;
    }

    public RaindropConfig setPrintable(boolean printable) {
        this.printable = printable;
        return this;
    }

    public boolean isLockable() {
        return lockable;
    }

    public RaindropConfig setLockable(boolean lockable) {
        this.lockable = lockable;
        return this;
    }

    public int getApiCode() {
        return apiCode;
    }

    public RaindropConfig setApiCode(int apiCode) {
        this.apiCode = apiCode;
        return this;
    }

    public String getApiMessage() {
        return apiMessage;
    }

    public RaindropConfig setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
        return this;
    }

    public void build() {

        Log.i("raindrop", "------------------------------------------------------------");
        Log.i("raindrop", "----------------- raindrop config success ------------------");
        Log.i("raindrop", "------------------------------------------------------------");

    }
}

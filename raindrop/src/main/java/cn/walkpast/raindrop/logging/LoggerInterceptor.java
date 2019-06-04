package cn.walkpast.raindrop.logging;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 12:54.
 * modify at: 2019/6/3 12:54.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class LoggerInterceptor {

    /**
     * log tag
     */
    private String logTag="raindrop_log";
    /**
     * log level
     */
    private  HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
    /**
     * whether print log or not
     */
    private boolean printable=true;

    public String getLogTag() {
        return logTag;
    }

    public LoggerInterceptor setLogTag(String logTag) {
        this.logTag = logTag;
        return this;
    }

    public  HttpLoggingInterceptor.Level getLevel() {
        return level;
    }

    public LoggerInterceptor setLevel(HttpLoggingInterceptor.Level level) {
        this.level = level;
        return this;
    }

    public boolean isPrintable() {
        return printable;
    }

    public LoggerInterceptor setPrintable(boolean printable) {
        this.printable = printable;
        return this;
    }

   public HttpLoggingInterceptor build(){
       return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
           @Override
           public void log(String message) {
               Log.i(getLogTag(),message);
           }
       }).setLevel(getLevel());
   }
}

package cn.walkpast.raindrop.exception;

import android.util.Log;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * @author: Kern Hu
 * @emali: create at: 2019/6/3 17:47.
 * modify at: 2019/6/3 17:47.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class ExceptionHelper {

    public static String handleException(Throwable e) {
        e.printStackTrace();
        String error;
        if (e instanceof SocketTimeoutException) {
            error = "network connections is erroneous";
        } else if (e instanceof ConnectException) {
            error = "network connections is erroneous";
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            error = "data parsing exception";
        } else if (e instanceof ApiException) {
            error = e.getCause().getMessage();
        } else if (e instanceof UnknownHostException) {
            error = "network connections is erroneous";
        } else if (e instanceof IllegalArgumentException) {
            error = "the file of download is exist";
        } else {
            error = "unknown error";
        }
        return error;
    }
}

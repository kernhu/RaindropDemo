package cn.walkpast.raindropdemo.common;

import com.google.gson.JsonElement;

import cn.walkpast.raindrop.BaseResponse;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/3 18:26.
 * modify at: 2019/6/3 18:26.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class CommonResponse extends BaseResponse {

    private int code;
    private String msg;
    private JsonElement data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

}

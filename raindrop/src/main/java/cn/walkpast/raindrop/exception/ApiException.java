package cn.walkpast.raindrop.exception;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 17:57.
 * modify at: 2019/6/3 17:57.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class ApiException extends RuntimeException {

    private int code;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public ApiException(String message) {
        super(new Throwable(message));

    }
}

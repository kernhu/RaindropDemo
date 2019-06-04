package cn.walkpast.raindrop.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/4 15:59.
 * modify at: 2019/6/4 15:59.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class RaindropSSLSocketFactory {

    public static SSLSocketFactory getSSLSocketFactory() {
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("TLS");
            TrustManager[] trustManagers = {new RaindropX509TrustManager()};
            context.init(null, trustManagers, new SecureRandom());
            return context.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }
}

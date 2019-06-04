package cn.walkpast.raindropdemo.common;

import cn.walkpast.raindrop.connector.Connector;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/4 16:37.
 * modify at: 2019/6/4 16:37.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class TestConnector implements Connector {

    @Override
    public String baseUrlForDebug() {

        return "https://wis.qq.com/";
    }

    @Override
    public String baseUrlForPreannouncedd() {
        return "https://wis.qq.com/";
    }

    @Override
    public String baseUrlForReleasedd() {

        return "https://wis.qq.com/";
    }

}

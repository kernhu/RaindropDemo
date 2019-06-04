package cn.walkpast.raindropdemo.ac.contact;

import cn.walkpast.raindrop.base.presenter.RaindropPresenter;
import cn.walkpast.raindrop.base.view.RaindropView;
import cn.walkpast.raindropdemo.common.CommonResponse;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/3 15:16.
 * modify at: 2019/6/3 15:16.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public interface WeatherContact {


    interface view extends RaindropView {

        String getCity();

        void setCityError(String error);

        void setSubmitResult(CommonResponse response);

        void setSubmitError(String tag, String error);

    }

    interface presenter extends RaindropPresenter {

        void getSubmitResult();
    }

}

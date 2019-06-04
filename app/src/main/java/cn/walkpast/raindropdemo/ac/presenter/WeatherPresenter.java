package cn.walkpast.raindropdemo.ac.presenter;

import android.text.TextUtils;

import cn.walkpast.raindrop.ExceptionTags;
import cn.walkpast.raindrop.base.presenter.RaindropPresenterImpl;
import cn.walkpast.raindrop.exception.ExceptionHelper;
import cn.walkpast.raindropdemo.common.CommonResponse;
import cn.walkpast.raindropdemo.ac.contact.WeatherContact;
import cn.walkpast.raindropdemo.ac.service.WeatherApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Kern Hu
 * @emali: create at: 2019/6/3 15:20.
 * modify at: 2019/6/3 15:20.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class WeatherPresenter extends RaindropPresenterImpl<WeatherContact.view> implements WeatherContact.presenter {

    public WeatherPresenter(WeatherContact.view view) {
        super(view);
    }

    @Override
    public void getSubmitResult() {

        if (TextUtils.isEmpty(view.getCity())) {
            view.setCityError("the city is empty");
            return;
        }

        WeatherApi
                .getInstance()
                .submit(view.getCity())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showLoadingDialog("loading ...");
                        addDisposable(disposable);
                    }
                })
                .map(new Function<CommonResponse, CommonResponse>() {

                    @Override
                    public CommonResponse apply(CommonResponse resp) throws Exception {
                        return resp;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommonResponse>() {

                    @Override
                    public void accept(CommonResponse resp) throws Exception {
                        view.dismissLoadingDialog();
                        view.setSubmitResult(resp);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
                        view.setSubmitError(ExceptionTags.THROWABLE, throwable.toString());
                        ExceptionHelper.handleException(throwable);
                    }
                });
    }
}

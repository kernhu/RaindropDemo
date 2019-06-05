package cn.walkpast.raindrop.base.presenter;

import io.reactivex.disposables.Disposable;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 14:11.
 * modify at: 2019/6/3 14:11.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public interface IRaindropPresenter {

    void start();

    void detach();

    void addDisposable(Disposable subscription);

    void unDisposable();

}

package cn.walkpast.raindrop.base.presenter;

import cn.walkpast.raindrop.base.view.RaindropView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 14:14.
 * modify at: 2019/6/3 14:14.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public abstract class RaindropPresenter<V extends RaindropView> implements IRaindropPresenter {

    protected V view;
    private CompositeDisposable mCompositeDisposable;

    public RaindropPresenter(V view) {
        this.view = view;
        start();
    }

    @Override
    public void detach() {
        this.view = null;
        unDisposable();
    }

    @Override
    public void start() {

    }

    @Override
    public void addDisposable(Disposable subscription) {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

}

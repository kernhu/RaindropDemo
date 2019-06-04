package cn.walkpast.raindrop.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import cn.walkpast.raindrop.base.presenter.RaindropPresenter;
import cn.walkpast.raindrop.base.view.RaindropView;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 14:26.
 * modify at: 2019/6/3 14:26.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public abstract class RaindropFragment  <P extends RaindropPresenter> extends Fragment implements RaindropView {

    protected P presenter;
    private boolean isViewCreate = false;
    private boolean isViewVisible = false;
    public Context context;
    private boolean isFirst = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewCreate = true;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isViewVisible = isVisibleToUser;
        if (isVisibleToUser && isViewCreate) {
            visibleToUser();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isViewVisible) {
            visibleToUser();
        }
    }

    protected void firstLoad() {

    }

    protected void visibleToUser() {
        if (isFirst) {
            firstLoad();
            isFirst = false;
        }
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.detach();
        }
        isViewCreate = false;
        super.onDestroyView();
    }

    public abstract P initPresenter();

}

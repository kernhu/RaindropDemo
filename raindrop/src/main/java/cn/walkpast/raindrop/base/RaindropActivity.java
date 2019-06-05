package cn.walkpast.raindrop.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.walkpast.raindrop.base.presenter.IRaindropPresenter;
import cn.walkpast.raindrop.base.view.RaindropView;
import cn.walkpast.raindrop.tools.ActivityHelper;

/**
 * @author: Kern Hu
 * @emali:
 * create at: 2019/6/3 14:19.
 * modify at: 2019/6/3 14:19.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public abstract class RaindropActivity<P extends IRaindropPresenter> extends AppCompatActivity implements RaindropView {

    protected P presenter;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActivityHelper.getInstance().addActivity(this);
        presenter = initPresenter();
    }

    @Override
    protected void onDestroy() {
        ActivityHelper.getInstance().removeActivity(this);
        if (presenter != null) {
            presenter.detach();
            presenter = null;
        }
        super.onDestroy();
    }


    public abstract P initPresenter();

}

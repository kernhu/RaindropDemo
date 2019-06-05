package cn.walkpast.raindropdemo.ac;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.walkpast.raindrop.common.ExceptionTags;
import cn.walkpast.raindrop.base.RaindropActivity;
import cn.walkpast.raindropdemo.R;
import cn.walkpast.raindropdemo.common.ApiStatus;
import cn.walkpast.raindropdemo.common.CommonResponse;
import cn.walkpast.raindropdemo.ac.contact.WeatherContact;
import cn.walkpast.raindropdemo.ac.model.WeatherBean;
import cn.walkpast.raindropdemo.ac.presenter.WeatherPresenter;
import cn.walkpast.raindropdemo.widget.LoadingDailog;

/**
 * @author: Kern Hu
 * @emali: huming@szprize.com
 * create at: 2019/6/3 14:47.
 * modify at: 2019/6/3 14:47.
 * develop version name :
 * modify version name :
 * description: This's ...
 */
public class WeatherActivity extends RaindropActivity<WeatherContact.presenter> implements WeatherContact.view, View.OnClickListener {

    @BindView(R.id.city)
    TextInputEditText city;
    @BindView(R.id.submit)
    TextView submit;
    @BindView(R.id.content)
    TextView content;

    LoadingDailog.Builder mLoadBuilder;
    LoadingDailog mLoadingDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.submit)
    @Override
    public void onClick(View view) {
        ((WeatherPresenter) presenter).getSubmitResult();
    }

    @Override
    public WeatherContact.presenter initPresenter() {
        return new WeatherPresenter(this);
    }

    @Override
    public void showLoadingDialog(String msg) {
        mLoadBuilder = new LoadingDailog.Builder(this)
                .setMessage(msg)
                .setCancelable(true)
                .setCancelOutside(true);
        mLoadingDailog = mLoadBuilder.create();
        mLoadingDailog.show();
    }

    @Override
    public void dismissLoadingDialog() {
        mLoadingDailog.dismiss();
    }

    @Override
    public String getCity() {
        return city.getText().toString().trim();
    }

    @Override
    public void setCityError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setSubmitResult(CommonResponse response) {

        switch (response.getCode()) {

            case ApiStatus.CODE://接口请求成功并且有返回数据

                WeatherBean bean = new Gson().fromJson(response.getData(), WeatherBean.class);
                content.setText("城市：" + bean.getCity()
                        + "\n" + "最高温度：" + bean.getForecast().get(0).getHigh()
                        + "\n" + "最低温度：" + bean.getForecast().get(0).getLow()
                        + "\n" + "风向：" + bean.getForecast().get(0).getFengxiang()
                        + "\n" + "天气：" + bean.getForecast().get(0).getType()
                        + "\n" + "日期：" + bean.getForecast().get(0).getDate()
                        + "\n" + "注意事项：" + bean.getGanmao()
                );

                break;
            default:

                setSubmitError(ExceptionTags.API_ERROR, response.getMsg());

                break;
        }
    }

    @Override
    public void setSubmitError(String tag, String error) {

        switch (tag) {
            case ExceptionTags.API_ERROR:
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
                break;
            case ExceptionTags.THROWABLE:

                Log.e("error", "error=" + error);

                break;
        }
    }
}

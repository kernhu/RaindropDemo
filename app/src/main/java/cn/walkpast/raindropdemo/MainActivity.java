package cn.walkpast.raindropdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.walkpast.raindropdemo.ac.WeatherActivity;
import cn.walkpast.raindropdemo.fr.FragmentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.item_ac)
    TextView mItemAC;
    @BindView(R.id.item_fr)
    TextView mItemFR;

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.item_ac, R.id.item_fr})
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.item_ac:

                mIntent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(mIntent);

                break;
            case R.id.item_fr:

                mIntent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(mIntent);

                break;
        }
    }
}

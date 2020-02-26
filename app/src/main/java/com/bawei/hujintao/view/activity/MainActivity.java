package com.bawei.hujintao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseActivity;
import com.bawei.hujintao.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.ma_img_head)
    ImageView maImgHead;
    @BindView(R.id.ma_btn_rl)
    Button maBtnRl;

    @Override
    protected void initData() {
        boolean key = getIntent().getBooleanExtra("key", false);
        if (key){
            maImgHead.setImageResource(R.mipmap.ic_launcher_round);
        }
    }

    @Override
    protected void initView() {
        maBtnRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

}

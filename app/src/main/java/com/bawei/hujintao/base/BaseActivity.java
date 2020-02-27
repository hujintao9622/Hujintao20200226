package com.bawei.hujintao.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 功能:  activity
 * 作者:  胡锦涛
 * 时间:  2020/2/26 0026 下午 4:33
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mpresenter=providePresenter();
        if (mpresenter != null) {
            mpresenter.attach(this);
        }
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P providePresenter();

    protected abstract int layoutId();
}

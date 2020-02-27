package com.bawei.hujintao.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

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
           /* Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            //intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(intent,0);*/
           maImgHead.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void initView() {
        maBtnRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String action = data.getAction();
    }
    //封装activity跳转
    public void jump(){
        Intent intent = new Intent(MainActivity.this,RegisterLoginActivity.class);
        startActivity(intent);
        finish();
    }
}

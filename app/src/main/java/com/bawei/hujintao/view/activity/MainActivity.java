package com.bawei.hujintao.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseActivity;
import com.bawei.hujintao.base.BasePresenter;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.ma_img_head)
    SimpleDraweeView maImgHead;
    @BindView(R.id.ma_btn_rl)
    Button maBtnRl;

    @Override
    protected void initData() {
        boolean key = getIntent().getBooleanExtra("key", false);
        if (key){
            //Fresco加载图片
            Uri parse = Uri.parse("http://mobile.bwstudent.com/images/small/head_pic/2020-02-28/20200228163332.jpg");
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
            GenericDraweeHierarchy build = builder.setRoundingParams(RoundingParams.asCircle()).build();
            maImgHead.setImageURI(parse);
            maImgHead.setHierarchy(build);
            //加载渐变
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setDuration(3000);
            maImgHead.setAnimation(alphaAnimation);
            alphaAnimation.start();
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

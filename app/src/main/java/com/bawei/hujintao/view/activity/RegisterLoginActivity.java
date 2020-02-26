package com.bawei.hujintao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseActivity;
import com.bawei.hujintao.contract.IRegisterLoginContract;
import com.bawei.hujintao.model.bean.LoginBean;
import com.bawei.hujintao.model.bean.RegisterBena;
import com.bawei.hujintao.presenter.RegisLoginPresenter;
import com.blankj.utilcode.util.EncryptUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterLoginActivity extends BaseActivity<RegisLoginPresenter> implements IRegisterLoginContract.IView {


    @BindView(R.id.rl_phone)
    EditText rlPhone;
    @BindView(R.id.rl_pwd)
    EditText rlPwd;
    @BindView(R.id.rl_btn_regis)
    Button rlBtnRegis;
    @BindView(R.id.rl_btn_login)
    Button rlBtnLogin;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegisLoginPresenter providePresenter() {
        return new RegisLoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_register_login;
    }

    @Override
    public void onRegisSuccess(RegisterBena registerBena) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisFailure(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Intent intent = new Intent(RegisterLoginActivity.this,MainActivity.class);
        intent.putExtra("key",true);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.rl_btn_regis, R.id.rl_btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_btn_regis:
                String ph1 = rlPhone.getText().toString();
                if (TextUtils.isEmpty(ph1)){
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pw1 = rlPwd.getText().toString();
                if (TextUtils.isEmpty(pw1)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //加密
                String sub1 = EncryptUtils.encryptMD5ToString(pw1).substring(0, 6);
                mpresenter.getRegisData(ph1,sub1);
                break;
            case R.id.rl_btn_login:
                String ph2 = rlPhone.getText().toString();
                if (TextUtils.isEmpty(ph2)){
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pw2 = rlPwd.getText().toString();
                if (TextUtils.isEmpty(pw2)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                //加密
                String sub2 = EncryptUtils.encryptMD5ToString(pw2).substring(0, 6);
                mpresenter.getLoginData(ph2,sub2);
                break;
        }
    }
}

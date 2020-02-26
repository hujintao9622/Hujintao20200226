package com.bawei.hujintao.model;

import com.bawei.hujintao.contract.IRegisterLoginContract;
import com.bawei.hujintao.model.bean.LoginBean;
import com.bawei.hujintao.model.bean.RegisterBena;
import com.bawei.hujintao.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/2/26 0026 下午 4:40
 */
public class RegisLoginModel implements IRegisterLoginContract.IModel {
    @Override
    public void getRegisData(String phone, String pwd, IReModelCall iReModelCall) {
        NetUtil.getInstance().getApi().regis(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBena>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBena registerBena) {
                        iReModelCall.onRegisSuccess(registerBena);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iReModelCall.onRegisFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLoginData(String phone, String pwd, ILoModelCall iLoModelCall) {
        NetUtil.getInstance().getApi().log(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iLoModelCall.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iLoModelCall.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

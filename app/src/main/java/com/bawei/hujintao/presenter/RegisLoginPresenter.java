package com.bawei.hujintao.presenter;

import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.IRegisterLoginContract;
import com.bawei.hujintao.model.RegisLoginModel;
import com.bawei.hujintao.model.bean.LoginBean;
import com.bawei.hujintao.model.bean.RegisterBena;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/2/26 0026 下午 4:50
 */
public class RegisLoginPresenter extends BasePresenter<IRegisterLoginContract.IView> implements IRegisterLoginContract.IPresenter {

    private RegisLoginModel regisLoginModel;

    @Override
    protected void initModel() {
        regisLoginModel = new RegisLoginModel();
    }

    @Override
    public void getRegisData(String phone, String pwd) {
        regisLoginModel.getRegisData(phone, pwd, new IRegisterLoginContract.IModel.IReModelCall() {
            @Override
            public void onRegisSuccess(RegisterBena registerBena) {
                view.onRegisSuccess(registerBena);
            }

            @Override
            public void onRegisFailure(Throwable throwable) {
                view.onRegisFailure(throwable);
            }
        });
    }

    @Override
    public void getLoginData(String phone, String pwd) {
        regisLoginModel.getLoginData(phone, pwd, new IRegisterLoginContract.IModel.ILoModelCall() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }
}

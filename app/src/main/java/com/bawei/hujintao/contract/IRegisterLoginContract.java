package com.bawei.hujintao.contract;

import com.bawei.hujintao.model.bean.LoginBean;
import com.bawei.hujintao.model.bean.RegisterBena;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/2/26 0026 下午 4:45
 */
public interface IRegisterLoginContract {
    interface IView{
        void onRegisSuccess(RegisterBena registerBena);
        void onRegisFailure(Throwable throwable);
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);
    }
    interface IPresenter{
        void getRegisData(String phone,String pwd);
        void getLoginData(String phone,String pwd);
    }
    interface IModel{
        void getRegisData(String phone,String pwd,IReModelCall iReModelCall);
        void getLoginData(String phone,String pwd,ILoModelCall iLoModelCall);
        interface IReModelCall{
            void onRegisSuccess(RegisterBena registerBena);
            void onRegisFailure(Throwable throwable);
        }
        interface ILoModelCall{
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
        }

    }
}

package com.bawei.hujintao.base;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/2/26 0026 下午 4:32
 */
public abstract class BasePresenter <V>{
    protected V view;
    public void attach(V view) {
        this.view = view;
    }
    //解决内存泄露
    public void detach(){
        view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}

package com.base.mvp;

/**
 * Created by ferhat on 11/19/2017.
 */

public class BasePresenter {

    public BaseView view;

    public void setView(BaseView view) {
        this.view = view;
    }

    public BaseView getView() {
        return view;
    }
}

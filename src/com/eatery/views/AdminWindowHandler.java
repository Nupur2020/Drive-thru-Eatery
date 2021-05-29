package com.eatery.views;

public class AdminWindowHandler implements ViewHandler{
    ViewHandler viewHandler;
    @Override
    public void setNextView(ViewHandler viewhandler) {
        this.viewHandler = viewhandler;
    }

    @Override
    public void handle() {

    }
}

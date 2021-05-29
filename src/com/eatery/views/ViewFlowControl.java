package com.eatery.views;

public class ViewFlowControl {

    public void thistry() {
        ViewHandler firstWindowHandler = new FirstWindowHandler();
        ViewHandler adminWindowHandler = new AdminWindowHandler();
        ViewHandler addItemWindowHandler = new AddItemWindowHandler();

        firstWindowHandler.setNextView(adminWindowHandler);
        adminWindowHandler.setNextView(addItemWindowHandler);



    }


}

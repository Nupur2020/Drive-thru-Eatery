package com.eatery.views;

import com.eatery.controllers.IController;
import com.eatery.controllers.ItemChangedListener;

public abstract class View implements ItemChangedListener {
    protected IController controller;

    public View(IController controller) {
        this.controller = controller;
    }

    public View() {

    }
}

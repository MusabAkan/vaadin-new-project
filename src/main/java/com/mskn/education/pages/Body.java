package com.mskn.education.pages;

import com.vaadin.ui.HorizontalLayout;

public class Body extends HorizontalLayout {

    public Body() {
        setSizeFull();
        buidContentLayout();
    }


    private void buidContentLayout() {
        Content contentPage = new Content();
        Sidebar sidebar = new Sidebar(contentPage);

        addComponent(sidebar);
        addComponent(contentPage);

        setExpandRatio(sidebar, 0.2f);
        setExpandRatio(contentPage, 0.8f);
    }
}
package com.mskn.education.components;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderLabel extends Label {
    public HeaderLabel() {

        addStyleName(ValoTheme.LABEL_COLORED);
        setHeight("500px");
        setWidth("500px");
        setCaption("KÜTÜPHANE PROGRAMI");

        setSizeFull();


    }
}

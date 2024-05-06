package com.mskn.education.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class LaListButton extends Button {

    public LaListButton() {
        setIcon(FontAwesome.LIST);
        addStyleName(ValoTheme.BUTTON_BORDERLESS);
    }
}

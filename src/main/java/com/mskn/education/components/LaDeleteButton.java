package com.mskn.education.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class LaDeleteButton extends Button {

    public LaDeleteButton() {
        addStyleName(ValoTheme.BUTTON_DANGER);
        setIcon(FontAwesome.TRASH);
    }
}
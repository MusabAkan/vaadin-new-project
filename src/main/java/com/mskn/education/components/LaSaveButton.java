package com.mskn.education.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class LaSaveButton extends Button {

    public LaSaveButton() {
        setIcon(FontAwesome.SAVE);
        addStyleName(ValoTheme.BUTTON_FRIENDLY);
    }
}
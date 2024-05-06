package com.mskn.education.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class LaSidebarButton extends Button {

    public LaSidebarButton() {
        addStyleName(ValoTheme.BUTTON_LINK);
        addStyleName(ValoTheme.BUTTON_LARGE);
    }
}
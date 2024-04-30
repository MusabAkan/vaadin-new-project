package com.mskn.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class MusabDeleteButton extends Button {

    public MusabDeleteButton() {
        addStyleName(ValoTheme.BUTTON_DANGER);
        setIcon(FontAwesome.TRASH);
    }
}

package com.mskn.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class MusabSaveButton extends Button {

    public MusabSaveButton() {
        addStyleName(ValoTheme.BUTTON_PRIMARY);
        setIcon(FontAwesome.SAVE);
    }

}

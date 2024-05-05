package com.mskn.components;

import com.vaadin.client.ui.Icon;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

import javax.swing.*;

public class SaveButton extends Button {
    public SaveButton() {
        setCaption("Click me");
        setIcon(FontAwesome.SAVE);
        addStyleName(ValoTheme.BUTTON_PRIMARY);
    }

}

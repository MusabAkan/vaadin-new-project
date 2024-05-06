package com.mskn.education.components;

import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class LaTextField extends TextField {

    public LaTextField() {
        addStyleName(ValoTheme.TEXTFIELD_ALIGN_CENTER);
    }
}
package com.mskn.education.pages;

import com.mskn.education.components.HeaderLabel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends VerticalLayout {
    public Header() {
        buildHeaderLayout();
    }

    private void buildHeaderLayout() {

        HeaderLabel headerLabel = new HeaderLabel();
        setMargin(true);
        addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        addComponent(headerLabel);
    }
}

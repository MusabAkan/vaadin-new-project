package com.mskn.education.components;

import com.mskn.education.enums.EnumCategory;
import com.vaadin.ui.ComboBox;

public class LaCategoryCombobox extends ComboBox {

    public LaCategoryCombobox() {
        for (EnumCategory category : EnumCategory.values()) {
            addItem(category);
        }
        setCaption("Kitap Kategori");
    }
}
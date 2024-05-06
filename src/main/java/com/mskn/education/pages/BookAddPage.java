package com.mskn.education.pages;

import com.mskn.education.components.LaCategoryCombobox;
import com.mskn.education.components.LaSaveButton;
import com.mskn.education.components.LaTextField;
import com.mskn.education.enums.EnumCategory;
import com.mskn.education.model.Book;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class BookAddPage extends VerticalLayout {

    private FormLayout formLayout;

    public BookAddPage() {
        buildLayout();
    }

    private void buildLayout() {
        formLayout = new FormLayout();

        LaTextField id = new LaTextField();
        id.setCaption("Id");
        formLayout.addComponents(id);

        LaTextField name = new LaTextField();
        name.setCaption("Adı");
        formLayout.addComponent(name);

        LaCategoryCombobox laCategoryCombobox = new LaCategoryCombobox();
        laCategoryCombobox.setCaption("Kategori");
        formLayout.addComponents(laCategoryCombobox);

        LaSaveButton button = new LaSaveButton();
        button.addClickListener(clickEvent -> {

            Content contentPage = (Content) getParent();
            List<Book> bookList = contentPage.getBookList();

            String nameStr = name.getValue();
            EnumCategory categoryComboboxValue = (EnumCategory) laCategoryCombobox.getValue();

            Book book = new Book();
            book.setId(1L);
            book.setName(nameStr);
            book.setCategory(categoryComboboxValue);
            bookList.add(book);

            Notification.show("EKLENDİ");
        });
        formLayout.addComponent(button);


        addComponent(formLayout);
    }
}
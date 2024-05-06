package com.mskn.education.pages;

import com.mskn.components.SaveButton;
import com.mskn.education.model.Book;
import com.vaadin.ui.*;

import java.util.Set;

public class LibraryAddPage extends VerticalLayout {


    private FormLayout formLayout;
    private Set<Book> books;

    public LibraryAddPage(Set<Book> books) {
        this.books = books;
        setSizeFull();
        buildLibraryLayout();
        addComponent(formLayout);
    }

    private void buildLibraryLayout() {
        formLayout = new FormLayout();

        TextField id = new TextField();
        id.setCaption("Kütüphane ID");
        formLayout.addComponents(id);

        TextField name = new TextField();
        name.setCaption("Kütüphane Adı");
        formLayout.addComponent(name);

        Button saveButton = new SaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        formLayout.addComponent(saveButton);
    }
}

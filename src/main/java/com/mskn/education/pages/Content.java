package com.mskn.education.pages;

import com.mskn.education.model.Book;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;


public class Content extends VerticalLayout {

    private List<Book> bookList = new ArrayList<Book>();

    public Content() {
        Notification.show("Content Page");
        setMargin(true);
        setSpacing(true);
        setSizeFull();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
package com.mskn.education.pages;

import com.mskn.MyUI;
import com.mskn.components.MusabUI;
import com.mskn.education.components.LaSidebarButton;
import com.mskn.education.model.Book;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class Sidebar extends VerticalLayout {


    private Content contentPage;

    public Sidebar(Content contentPage) {
        this.contentPage = contentPage;

        setMargin(true);
        setSpacing(true);

        builSidebarLayout();
    }

    private void builSidebarLayout() {
        buildAddBookButton();
        buildDeleteBookButton();
        buildUpdateBookButton();
        buildListBookButton();
    }

    private void buildListBookButton() {
        LaSidebarButton laListButton = new LaSidebarButton();
        laListButton.setIcon(FontAwesome.LIST);
        laListButton.setCaption("Kitapları Listele");
        laListButton.addClickListener(clickEvent -> {

            MyUI myUI = (MyUI) UI.getCurrent();
            List<Book> uiBookList = myUI.getUiBookList();

        });
        addComponent(laListButton);
    }

    private void buildUpdateBookButton() {
        LaSidebarButton laSaveButton = new LaSidebarButton();
        laSaveButton.setIcon(FontAwesome.SAVE);
        laSaveButton.setCaption("Kitap Kaydet");
        laSaveButton.addClickListener(clickEvent -> {

        });
        addComponent(laSaveButton);
    }

    private void buildDeleteBookButton() {

        LaSidebarButton laDeleteButton = new LaSidebarButton();
        laDeleteButton.setIcon(FontAwesome.TRASH);
        laDeleteButton.setCaption("Kitap Sil");
        laDeleteButton.addClickListener(clickEvent -> {
            MusabUI musabUI = new MusabUI();
            musabUI.buildContent();
            contentPage.removeAllComponents();
            contentPage.addComponent(musabUI.layout);
        });
        addComponent(laDeleteButton);
    }

    private void buildAddBookButton() {
        LaSidebarButton laSaveButton = new LaSidebarButton();
        laSaveButton.setIcon(FontAwesome.SAVE);
        laSaveButton.setCaption("Kitap Ekle");
        laSaveButton.addClickListener(clickEvent -> {
            BookAddPage bookAddPage = new BookAddPage();
            contentPage.removeAllComponents();
            contentPage.addComponent(bookAddPage);
        });
        addComponent(laSaveButton);
    }
}
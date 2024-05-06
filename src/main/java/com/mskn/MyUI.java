package com.mskn;

import javax.servlet.annotation.WebServlet;

import com.mskn.education.model.Book;
import com.mskn.education.pages.Body;
import com.mskn.education.pages.Header;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.mskn.MyAppWidgetset")
public class MyUI extends UI {

    private List<Book> uiBookList = new ArrayList<Book>();

    VerticalLayout layout = new VerticalLayout();


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        buildContent();
    }

    private void buildContent() {

        builContent();
        setContent(layout);
    }

    private void builContent() {

        layout.setSizeFull();

        Header header = new Header();
        layout.addComponent(header);

        Body body = new Body();
        layout.addComponent(body);

        layout.setExpandRatio(body, 1);
    }

    public List<Book> getUiBookList() {
        return uiBookList;
    }

    public void setUiBookList(List<Book> uiBookList) {
        this.uiBookList = uiBookList;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
package com.mskn;

import javax.servlet.annotation.WebServlet;

import com.mskn.components.MusabDeleteButton;
import com.mskn.components.MusabSaveButton;
import com.mskn.components.MusabTextField;
import com.mskn.components.MusabUI;
import com.mskn.model.Phone;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Container;
import com.vaadin.data.util.filter.Like;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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


    @Override
    protected void init(VaadinRequest vaadinRequest) {


      /*MusabUI ui = new MusabUI();
        ui.buildContent();
        setContent(ui.layout);
       */

        //loadMain();

        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        TextField name1 = new TextField("Somebody's name");
        TextField name2 = new TextField("somebody's name");

        layout.addComponent(name1);
        layout.addComponent(name2);


        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                /* Label label = new Label("Thank your for clicking");*/
                String nameGetValue1 = name1.getValue();
                String nameGetValue2 = name2.getValue();
                String phrease = getFunnyPhrase(nameGetValue1, nameGetValue2);
                Label label = new Label(phrease);
                layout.addComponent(label);
                String message = "User created : " + label.getValue();
                Notification.show(message);
            }
        });

        layout.addComponent(button);

    }

    public String getFunnyPhrase(String name1, String name2) {
        String[] verbs = new String[]{
                "eats", "melts", "braks", "washes", "sells"
        };

        String[] bodyParts = new String[]{
                "heads", "hands", "waist", "eyes", "elbows"
        };

        String text = name1 + " ";
        text += verbs[getAnInt(verbs)] + " ";
        text += name2 + "'s ";
        text += bodyParts[getAnInt(bodyParts)];

        return text;
    }

    private int getAnInt(String[] strings) {
        return (int) (Math.random() * 100 % strings.length);
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
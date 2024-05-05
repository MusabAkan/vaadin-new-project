package com.mskn;

import javax.servlet.annotation.WebServlet;

import com.mskn.components.SaveButton;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.client.debug.internal.Icon;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

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

    String[] strings = new String[]{"İstanbul", "Ankara", "Rize", "Konya", "Sakarya", "İzmir", "Samsun"};

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        layout.setMargin(true);
        setContent(layout);


        ComboBox cmbList = new ComboBox("Select an option");
        cmbList.isNullSelectionAllowed();
        for (String string : strings) {
            cmbList.addItem(string);
        }

        layout.addComponent(cmbList);


        SaveButton button = new SaveButton();



        button.setDescription("Kardeş bak beni tıklama la :)");

        button.addClickListener(clickEvent -> {
            Object value = cmbList.getValue();

            if (value == null) {
                UserError componentError = new UserError("Lütfen boş geçmeyiniz!");
                cmbList.setComponentError(componentError);
            } else if (!IsWithContainsCity(value.toString())) {
                UserError componentError = new UserError("Lütfen şehir seçiminizi yapınız!");
                cmbList.setComponentError(componentError);
            } else {
                cmbList.setComponentError(null); // Temizlemek için yapılıyor
                //button.setEnabled(false);
            }
        });

        layout.addComponent(button);
    }

    private boolean IsWithContainsCity(String string) {
        for (String str : strings) {
            if (str.contains(string)) {
                return true;
            }
        }
        return false                ;
    }


    private void workPhrease() {
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
package com.mskn.components;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.UserError;
import com.vaadin.ui.*;

public class VaaadinDocumentUI {
    public void cmbTextLayout() {


        layout.setMargin(true);

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

    public VerticalLayout layout = new VerticalLayout();

    String[] strings = new String[]{"İstanbul", "Ankara", "Rize", "Konya", "Sakarya", "İzmir", "Samsun"};
    private boolean IsWithContainsCity(String string) {
        for (String str : strings) {
            if (str.contains(string)) {
                return true;
            }
        }
        return false                ;
    }
    private void objectProperty() {
    /*
    İki UI bileşenini tek bir veri kaynağına bağladık. Bileşenlerden biri (TextField)
    veri kaynağını (ObjectProperty) değiştirebilirken, diğeri sadece
    veri kaynağındaki veriler. İşte bir ekran görüntüsü:
    TextField bileşenindeki değeri değiştirirseniz, bu da veri kaynağını değiştirecektir,
    Label bileşeninin yeni değeri görüntülemesine neden olur. textField ve label bileşenlerinin her ikisi de
    ObjectProperty örneği aracılığıyla aynı veri kaynağına bağlanır:
    Bu kullanışlıdır çünkü tek bir veri kaynağını birden fazla görünüme kolayca ekleyebiliriz
    (UI bileşenleri).
    Özellik nedir? Belirli bir türde değer içeren bir nesnedir. İçinde
    önceki örnekte, tür String idi. Property sınıfı bir arayüzdür ve Vaadin
    bu arayüz için birkaç uygulama sağlar. Biz ObjectProperty kullanıyoruz
    uygulaması, herhangi bir Java nesnesini bir özelliğe sarmalamamıza olanak tanır.

    * */
        ObjectProperty<String> property = new ObjectProperty<>("the value");

        TextField textField = new TextField("Data");

        textField.setImmediate(true);
        Label label = new Label();
        Label label2 = new Label();

        textField.setPropertyDataSource(property);
        label.setPropertyDataSource(property);
        label2.setPropertyDataSource(property);

        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(textField);
        layout.addComponent(label);
        layout.addComponent(label2);

    }

    public void workPhrease() {

        layout.setMargin(true);


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

    private String getFunnyPhrase(String name1, String name2) {
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
}

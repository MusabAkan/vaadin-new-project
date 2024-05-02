package com.mskn;

import javax.servlet.annotation.WebServlet;

import com.mskn.components.MusabDeleteButton;
import com.mskn.components.MusabSaveButton;
import com.mskn.components.MusabTextField;
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

    Phone selectItem;
    String fullNameStr = "fullName";
    String phoneNumberStr = "phoneNumber";

    Set<Phone> phoneList = new HashSet<Phone>();

    VerticalLayout layout;

    FormLayout filterLayout;
    MusabTextField txtSearchFullName;
    MusabTextField txtSearchPhoneNumber;

    Table tblData;

    HorizontalLayout detailLayout;
    FormLayout detailLeftLayout;
    MusabTextField txtFullName;
    MusabTextField txtPhoneNumber;
    FormLayout detailRightLayout;
    MusabSaveButton btnSave;
    MusabDeleteButton btnDelete;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        buildContent();
        setContent(layout);
    }

    private void buildContent() {

        layout = new VerticalLayout();
        layout.setMargin(true);

        buildFilterLayout();
        layout.addComponent(filterLayout);

        buildTable();
        layout.addComponent(tblData);

        buildDetailLayout();
        layout.addComponent(detailLayout);
    }

    private void buildTable() {
        tblData = new Table();
        tblData.addContainerProperty(fullNameStr, String.class, null);
        tblData.addContainerProperty(phoneNumberStr, String.class, null);
        tblData.setSelectable(true);
        tblData.setSizeFull();
        selectedItem();

    }

    private void selectedItem() {
        tblData.addItemClickListener(event -> {
            Object item = event.getItemId();
            selectItem = (Phone) item;
            fillAllText();
        });
    }

    private void fillAllText() {
        String fullName = selectItem.getFullName();
        txtFullName.setValue(fullName);

        String phoneNumber = selectItem.getPhoneNumber();
        txtPhoneNumber.setValue(phoneNumber);
    }

    private void buildDetailLayout() {

        detailLayout = new HorizontalLayout();

        buildDetailLeftLayout();
        detailLayout.addComponent(detailLeftLayout);

        builDetailRightLayout();
        detailLayout.addComponent(detailRightLayout);
    }

    private void buildDetailLeftLayout() {
        detailLeftLayout = new FormLayout();

        txtFullName = new MusabTextField();
        txtFullName.setCaption("Ad Soyad :");
        detailLeftLayout.addComponents(txtFullName);

        txtPhoneNumber = new MusabTextField();
        txtPhoneNumber.setCaption("Telefon No :");
        detailLeftLayout.addComponents(txtPhoneNumber);
    }

    private void builDetailRightLayout() {
        detailRightLayout = new FormLayout();

        buildSaveButton();
        detailRightLayout.addComponents(btnSave);

        buildDeleteButton();
        detailRightLayout.addComponents(btnDelete);
    }

    private void buildSaveButton() {
        btnSave = new MusabSaveButton();
        btnSave.addClickListener(event -> {
            saveListItem();
            fillTable();
            clearField();
        });
    }

    private void fillTable() {
        tblData.removeAllItems();
        for (Phone phone : phoneList) {
            tblData.addItem(phone);
            tblData.getContainerProperty(phone, fullNameStr).setValue(phone.getFullName());
            tblData.getContainerProperty(phone, phoneNumberStr).setValue(phone.getPhoneNumber());
        }
    }

    private void saveListItem() {

        String phoneNumber = txtPhoneNumber.getValue();
        String fullName = txtFullName.getValue();

        Phone phoneVal = new Phone(phoneNumber, fullName);

        if (phoneList.equals(phoneVal)) {
            clearField();
        } else if (selectItem == null) {
            phoneList.add(phoneVal);
        } else {
            phoneVal = selectItem;
            phoneVal.setPhoneNumber(phoneNumber);
            phoneVal.setFullName(fullName);
        }

        clearField();
    }

    private void buildDeleteButton() {
        btnDelete = new MusabDeleteButton();
        btnDelete.addClickListener(event -> {
            selectDeletedItem();
            clearField();
        });
    }

    private void selectDeletedItem() {
        if (selectItem != null)
            phoneList.remove(selectItem);
        fillTable();
    }

    private void clearField() {
        txtPhoneNumber.clear();
        txtFullName.clear();
        txtSearchFullName.clear();
        txtSearchPhoneNumber.clear();
        selectItem = null;
    }

    private void buildFilterLayout() {
        filterLayout = new FormLayout();

        txtSearchFullName = new MusabTextField();
        txtSearchFullName.setCaption("Ad Soyad Ara...");
        txtSearchFullName.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String searchFullName = event.getText();
                filterSearch(searchFullName, fullNameStr);
            }
        });
        filterLayout.addComponent(txtSearchFullName);

        txtSearchPhoneNumber = new MusabTextField();
        txtSearchPhoneNumber.setCaption("Telefon No Ara..");
        txtSearchPhoneNumber.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {

                String searchPhoneNumber = event.getText();
                filterSearch(searchPhoneNumber, phoneNumberStr);
            }
        });

        filterLayout.addComponents(txtSearchPhoneNumber);
    }

    private void filterSearch(String filterString, String columnName) {
        Container.Filterable filter = (Container.Filterable) (tblData.getContainerDataSource());
        filter.removeAllContainerFilters();
        if (filterString.length() > 0)
            filter.addContainerFilter(new Like(columnName, "%" + filterString + "%"));
        //todo:Burayı daha sonrası  geliştirme yap çünkü 1  filterleme değilde ikisiyle birlkte sorgulanması isternirse şu aşağıdaki gibi olabilir

    }

    private static void sendMessage(String str) {
        Notification test = new Notification(str);
        test.show(Page.getCurrent());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
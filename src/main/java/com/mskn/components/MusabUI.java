package com.mskn.components;
import com.mskn.model.Phone;
import com.vaadin.data.Container;
import com.vaadin.data.util.filter.Like;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Page;
import com.vaadin.ui.*;

import java.util.HashSet;
import java.util.Set;

public class MusabUI
{
    Phone selectItem;
    String fullNameStr = "fullName";
    String phoneNumberStr = "phoneNumber";

    Set<Phone> phoneList = new HashSet<Phone>();

    public VerticalLayout layout;

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

    public void buildContent() {

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
        clearField();

        Phone phoneVal = new Phone(phoneNumber, fullName);


        if (phoneList.equals(phoneVal)) {
            return;
        } else if (selectItem == null) {
            phoneList.add(phoneVal);
        } else {
            phoneVal = selectItem;
            phoneVal.setPhoneNumber(phoneNumber);
            phoneVal.setFullName(fullName);
        }
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
}

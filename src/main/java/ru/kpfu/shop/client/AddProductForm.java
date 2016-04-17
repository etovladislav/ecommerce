package ru.kpfu.shop.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.kpfu.shop.client.service.GoodService;
import ru.kpfu.shop.client.service.GoodServiceAsync;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.service.impl.GoodServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etovladislav on 17.04.16.
 */
public class AddProductForm {

    private GoodServiceAsync goodServiceAsyncService = GWT.create(GoodService.class);

    public FormPanel getAddProductForm() {

        //category select
        final ListBox list = new ListBox();

        AsyncCallback<List<Category>> callback = new AsyncCallback<List<Category>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error");
            }

            @Override
            public void onSuccess(List<Category> categories) {
                for (Category category : categories) {
                    list.addItem(category.getName(), String.valueOf(category.getId()));
                }
            }

        };
        goodServiceAsyncService.getAllCategories(callback);
        VerticalPanel panel = new VerticalPanel();
        final FormPanel form = new FormPanel();
        form.setAction("/admin/add-product");
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        final Label status = new Label("");
        panel.add(status);
        //Product Name input
        Label productNameLabel = new Label("Название продукта");
        final TextBox nameForm = new TextBox();
        nameForm.getElement().setAttribute("type", "text");
        nameForm.setName("name");
        panel.add(productNameLabel);
        panel.add(nameForm);
        //End product name input

        //Product description input
        Label productDescriptionLabel = new Label("Описание продукта");
        final TextBox descriptionForm = new TextBox();
        descriptionForm.setName("description");
        panel.add(productDescriptionLabel);
        panel.add(descriptionForm);
        //End product name input

        //Product price input
        Label priceProductLabel = new Label("Цена продукта");
        final TextBox priceProductForm = new TextBox();
        priceProductForm.setName("price");
        priceProductForm.getElement().setAttribute("type", "number");
        panel.add(priceProductLabel);
        panel.add(priceProductForm);
        //End product price input

        //Product category select
        Label categoryProductLabel = new Label("Категория:");
        list.setVisibleItemCount(0);
        list.setName("categoryId");
        panel.add(categoryProductLabel);
        panel.add(list);
        //end product category

        //FileUpload input
        Label fileUploadLabel = new Label("Select a file:");
        final FileUpload fileUpload = new FileUpload();
        fileUpload.setName("img");
        panel.add(fileUploadLabel);
        panel.add(fileUpload);
        //end FileUpload input

        Button uploadButton = new Button("Добавить");
        panel.add(uploadButton);

        uploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String filename = fileUpload.getFilename();
                if (filename.length() == 0) {
                    status.setText("Заполните все поля!");
                } else {
                    form.submit();
                }
            }
        });

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                status.setText("Продукт успешно добавлен!");
                priceProductForm.setValue("");
                descriptionForm.setValue("");
                nameForm.setValue("");
            }
        });
        panel.setSpacing(10);

        form.add(panel);
        return form;
    }
}

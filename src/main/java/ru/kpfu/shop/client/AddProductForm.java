package ru.kpfu.shop.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.kpfu.shop.client.service.GoodService;
import ru.kpfu.shop.client.service.GoodServiceAsync;
import ru.kpfu.shop.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by etovladislav on 17.04.16.
 */
public class AddProductForm {

    private GoodServiceAsync goodServiceAsyncService = GWT.create(GoodService.class);

    private AsyncCallback<List<Category>> callback;

    private static final String IMAGE_PATTERN
            = "/\\.(gif|jpg|JPEG|tiff|png)$/i";
    private static Logger rootLogger = Logger.getLogger("");

    final ListBox list = new ListBox();

    public FormPanel getAddProductForm() {

        //category select

        callback = new AsyncCallback<List<Category>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error");
            }

            @Override
            public void onSuccess(List<Category> categories) {
                int itemCount = list.getElement().getChildCount();
                if (itemCount != 0 && categories != null) {
                    for(int i = 0; i < itemCount; i++) {
                        list.removeItem(0);
                    }
                }

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
        final TextBox nameForm;
        nameForm = new TextBox();
        nameForm.getElement().setAttribute("type", "text");
        nameForm.setName("name");
        panel.add(productNameLabel);
        panel.add(nameForm);
        //End product name input

        //Product description input
        Label productDescriptionLabel = new Label("Описание продукта");
        final TextBox descriptionForm = new TextBox();
        descriptionForm.getElement().setAttribute("type", "text");
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
        Label fileUploadLabel = new Label("Выберете картинку:");
        final FileUpload fileUpload = new FileUpload();
        fileUpload.setName("img");
        fileUpload.getElement().setAttribute("accept",".png, .jpg, .jpeg");
        panel.add(fileUploadLabel);
        panel.add(fileUpload);
        //end FileUpload input

        Button uploadButton = new Button("Добавить");
        panel.add(uploadButton);

        uploadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String filename = fileUpload.getFilename();
                if (filename.length() == 0 || descriptionForm.getValue().length() == 0 || priceProductForm.getValue().length() == 0 ||
                        nameForm.getValue().length() == 0) {

                    status.setText("Заполните все поля!");
                    status.getElement().setClassName("error");
                } else {
                    form.submit();
                }
            }
        });

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                status.setText("Продукт успешно добавлен!");
                status.getElement().setClassName("success");
                priceProductForm.setValue("");
                descriptionForm.setValue("");
                nameForm.setValue("");
            }

        });
        panel.setSpacing(10);

        form.add(panel);
        return form;
    }

    public void refresCategories() {
        goodServiceAsyncService.getAllCategories(callback);
    }
}

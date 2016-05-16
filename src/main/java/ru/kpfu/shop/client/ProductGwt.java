package ru.kpfu.shop.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;


public class ProductGwt implements EntryPoint {


    public void onModuleLoad() {
        //Create an empty tab panel
        TabPanel tabPanel = new TabPanel();


        Label label2 = new Label("Создать категорию");
        label2.setHeight("200");
        Label label3 = new Label("Перейти на сайт");
        label3.setHeight("200");

        //create titles for tabs
        String tab1Title = "Добавить товар";
        String tab2Title = "Добавить категорию";
        String tab3Title = "Изменить товар";
        String tab4Title = "Список заказов";
        String tab5Title = "Перейти на сайт";
        String tab6Title = "Выход";
        //create tabs
        final AddProductForm addProductForm = new AddProductForm();
        final CreateCategoryForm createCategoryForm = new CreateCategoryForm();
        tabPanel.add(addProductForm.getAddProductForm(), tab1Title);
        tabPanel.add(createCategoryForm.getCreateCategoryForm(), tab2Title);
        tabPanel.add(new ProductList().getAddProductForm(), tab3Title);
        tabPanel.add(new OrderList().getAddProductForm(), tab4Title);
        tabPanel.add(createCategoryForm.getCreateCategoryForm(), tab5Title);
        tabPanel.add(createCategoryForm.getCreateCategoryForm(), tab6Title);

        //select first tab
        tabPanel.selectTab(0);

        //set width if tabpanel
        tabPanel.setWidth("800");

        tabPanel.setAnimationEnabled(true);
        tabPanel.addBeforeSelectionHandler(new BeforeSelectionHandler<Integer>() {
            @Override
            public void onBeforeSelection(BeforeSelectionEvent<Integer> beforeSelectionEvent) {
                if (beforeSelectionEvent.getItem() == 0) {
                    addProductForm.refresCategories();
                }
                if (beforeSelectionEvent.getItem() == 4) {
                    Window.Location.replace("http://localhost:8181/products");
                }
                if (beforeSelectionEvent.getItem() == 5) {
                    Window.Location.replace("http://localhost:8181/logout");
                }
            }
        });
        // Add the widgets to the root panel.
        RootPanel.get().add(tabPanel);
    }
}
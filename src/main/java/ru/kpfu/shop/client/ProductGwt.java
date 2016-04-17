package ru.kpfu.shop.client;

import com.google.gwt.core.client.EntryPoint;
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

        //create tabs
        tabPanel.add(new AddProductForm().getAddProductForm(), tab1Title);
        tabPanel.add(new CreateCategoryForm().getCreateCategoryForm(), tab2Title);
        tabPanel.add(label3, tab3Title);

        //select first tab
        tabPanel.selectTab(0);

        //set width if tabpanel
        tabPanel.setWidth("800");

        tabPanel.setAnimationEnabled(true);
        // Add the widgets to the root panel.
        RootPanel.get().add(tabPanel);


    }
}
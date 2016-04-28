package ru.kpfu.shop.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;

public class EditProductForm implements EntryPoint, ClickHandler {

    private static class MyDialog extends DialogBox {

        public MyDialog() {
            setText("My First Dialog");
            setAnimationEnabled(true);
            setGlassEnabled(true);
            Button ok = new Button("OK");
            ok.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    MyDialog.this.hide();
                }
            });
            setWidget(ok);
        }
    }

    public void onModuleLoad() {
        Button b = new Button("Click me");
        b.addClickHandler(this);

        RootPanel.get().add(b);
    }

    public void onClick(ClickEvent event) {
        // Instantiate the dialog box and show it.

    }
}

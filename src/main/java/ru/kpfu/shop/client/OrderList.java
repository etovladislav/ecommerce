package ru.kpfu.shop.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.kpfu.shop.client.service.GoodService;
import ru.kpfu.shop.client.service.GoodServiceAsync;
import ru.kpfu.shop.dto.OrderDTO;
import ru.kpfu.shop.dto.OrderDetailDTO;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.model.ShippingInfo;

import java.util.List;


/**
 * Created by etovladislav on 28.04.16.
 */
public class OrderList extends DialogBox {


    private GoodServiceAsync goodServiceAsyncService = GWT.create(GoodService.class);

    private AsyncCallback<List<Category>> callback;

    private AsyncCallback<List<Product>> callbackProduct;

    private AsyncCallback<List<OrderDTO>> orders;

    public FormPanel getEditProductForm(OrderDTO order, final MyDialog widgets) {
        VerticalPanel panel = new VerticalPanel();
        final FormPanel form = new FormPanel();
        ShippingInfo shippingInfo = order.getUser().getShippingInfo();
        final Label status = new Label("Пользователь: " + shippingInfo.getFio());
        final Label shippInf = new Label("Информация о доставке: ");
        final Label shippInf2 = new Label("Страна: " + shippingInfo.getCountry() + " Город: " +
                shippingInfo.getCity() + " " + shippingInfo.getStreet()
                + shippingInfo.getHouse());
        panel.add(status);
        panel.add(shippInf);
        panel.add(shippInf2);

        final ListBox lb = new ListBox();
        lb.setWidth("300");
        for (OrderDetailDTO orderDetail : order.getOrderDetail()) {
            lb.addItem(orderDetail.getProduct().getName() + ", Количество: " + orderDetail.getNumber());
        }
        panel.add(lb);
        form.add(panel);
        return form;
    }

    public VerticalPanel getAddProductForm() {

        final VerticalPanel panel = new VerticalPanel();

        Label label = new Label("Список заказов");

        orders = new AsyncCallback<List<OrderDTO>>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("ERROR!");
            }

            @Override
            public void onSuccess(final List<OrderDTO> orders) {
                final ListBox lb = new ListBox();
                lb.setWidth("300");
                for (final OrderDTO order : orders) {
                    lb.addItem(order.getId().toString(), order.getId().toString());
                }
                lb.addChangeListener(new ChangeListener() {
                    @Override
                    public void onChange(Widget widget) {
                        int itemSelected = lb.getSelectedIndex();
                        final MyDialog myDialog = new MyDialog(orders.get(itemSelected));
                        myDialog.show();
                    }
                });


                lb.setVisibleItemCount(orders.size());
                panel.add(lb);
            }
        };
        goodServiceAsyncService.getOrders(orders);
        return panel;
    }

    private static class MyDialog extends DialogBox {

        public MyDialog(OrderDTO order) {
            setText("My First Dialog");
            setAnimationEnabled(true);
            setGlassEnabled(true);
            setWidget(new OrderList().getEditProductForm(order, this));
        }
    }
}

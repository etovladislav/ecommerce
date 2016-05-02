package ru.kpfu.shop.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Product;

import java.util.List;

/**
 * Created by etovladislav on 16.04.16.
 */
public interface GoodServiceAsync {

    void getAllCategories(AsyncCallback<List<Category>> asyncCallback);

    void getProduct(Long id, AsyncCallback<Product> productAsyncCallback);

    void getProducts(AsyncCallback<List<Product>> asyncCallback);
}

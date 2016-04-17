package ru.kpfu.shop.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.kpfu.shop.model.Category;

import java.util.List;

/**
 * Created by etovladislav on 16.04.16.
 */
public interface GoodServiceAsync {

    void getAllCategories(AsyncCallback<List<Category>> asyncCallback);

}

package ru.kpfu.shop.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.kpfu.shop.model.Category;

import java.util.List;

/**
 * Created by etovladislav on 16.04.16.
 */
@RemoteServiceRelativePath("springGwtServices/goodService")
public interface GoodService extends RemoteService {

    List<Category> getAllCategories();

}

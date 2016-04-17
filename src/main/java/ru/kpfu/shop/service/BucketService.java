package ru.kpfu.shop.service;


public interface BucketService {

    void addProduct(Long productId);

    void deleteProduct(Long id);

    void changeNumberProduct(Long bucketId, Integer numberProduct);

}

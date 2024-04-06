package com.ashishhiggins.shoppinwebapp.service;

import com.ashishhiggins.shoppinwebapp.dto.ProductDto;
import com.ashishhiggins.shoppinwebapp.entity.Product;

public interface IProductService {

    /**
     *
     * @param productId
     * @return product details
     */
    ProductDto fetchProductById(Long productId);

    /**
     *
     * @param productDto
     */
    Product createProduct(ProductDto productDto);

}

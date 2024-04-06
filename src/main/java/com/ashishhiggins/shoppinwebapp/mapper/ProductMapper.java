package com.ashishhiggins.shoppinwebapp.mapper;

import com.ashishhiggins.shoppinwebapp.dto.ProductDto;
import com.ashishhiggins.shoppinwebapp.entity.Product;

public class ProductMapper {


        public static ProductDto mapToProductDto(Product product, ProductDto productDto) {
            productDto.setPrice(product.getPrice());
            productDto.setOrdered(product.getOrdered());
            productDto.setAvailable(product.getAvailable());
            return productDto;
        }

        public static Product mapToProduct(ProductDto productDto, Product product) {
            product.setPrice(productDto.getPrice());
            product.setOrdered(productDto.getOrdered());
            product.setAvailable(productDto.getAvailable());
            return product;
        }
}

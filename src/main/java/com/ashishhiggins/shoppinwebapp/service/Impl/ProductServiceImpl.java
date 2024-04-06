package com.ashishhiggins.shoppinwebapp.service.Impl;

import com.ashishhiggins.shoppinwebapp.dto.ProductDto;
import com.ashishhiggins.shoppinwebapp.entity.Product;
import com.ashishhiggins.shoppinwebapp.exception.ProductAlreadyExistsException;
import com.ashishhiggins.shoppinwebapp.exception.ProductNotFoundException;
import com.ashishhiggins.shoppinwebapp.mapper.ProductMapper;
import com.ashishhiggins.shoppinwebapp.repository.ProductRepository;
import com.ashishhiggins.shoppinwebapp.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    /**
     * @param productId
     * @return product details
     */
    @Override
    public ProductDto fetchProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product", "ProductId", productId.toString()));

        ProductDto productDto = ProductMapper.mapToProductDto(product, new ProductDto());

        return productDto;

    }


    /**
     * @param productDto
     */
    @Override
    public Product createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto, new Product());

//        Optional<Product> productOptional = productRepository.findById(product.getId());
//        if(productOptional.isPresent()) {
//            throw new ProductAlreadyExistsException("Product", "ProductId", product.getId().toString());
//        }

        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct.getId());

        return savedProduct;

    }
}

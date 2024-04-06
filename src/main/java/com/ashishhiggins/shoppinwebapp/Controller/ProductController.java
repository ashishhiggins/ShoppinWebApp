package com.ashishhiggins.shoppinwebapp.Controller;


import com.ashishhiggins.shoppinwebapp.dto.ProductDto;
import com.ashishhiggins.shoppinwebapp.entity.Product;
import com.ashishhiggins.shoppinwebapp.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apis/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProductController {

    private IProductService iProductService;

    @GetMapping(path = "/{productId}/inventory")
    public ResponseEntity<ProductDto> fetchProductById(@PathVariable Long productId) {
        ProductDto productDto = iProductService.fetchProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        Product product = iProductService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

}

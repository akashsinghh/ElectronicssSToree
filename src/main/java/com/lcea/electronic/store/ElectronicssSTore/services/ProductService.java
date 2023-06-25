package com.lcea.electronic.store.ElectronicssSTore.services;

import com.lcea.electronic.store.ElectronicssSTore.dtos.PageableResponse;
import com.lcea.electronic.store.ElectronicssSTore.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    //create
    ProductDto create(ProductDto productDto);
    //update
    ProductDto update(ProductDto productDto,String productId);
    //delete
    void delete(String productId);
    //get siingle
    ProductDto get(String productId);

    //get single
    PageableResponse<ProductDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);
    //getall
    PageableResponse<ProductDto>  getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir);
    //search product
    PageableResponse<ProductDto> searchByTitle(String subTitle,int pageNumber, int pageSize, String sortBy, String sortDir );
    //others methods

}

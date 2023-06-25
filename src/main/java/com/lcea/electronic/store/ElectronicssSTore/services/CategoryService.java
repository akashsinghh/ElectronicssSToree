package com.lcea.electronic.store.ElectronicssSTore.services;

import com.lcea.electronic.store.ElectronicssSTore.dtos.CategoryDto;
import com.lcea.electronic.store.ElectronicssSTore.dtos.PageableResponse;
import com.lcea.electronic.store.ElectronicssSTore.entities.Category;

public interface CategoryService {
    //create
    CategoryDto create(CategoryDto categoryDto);
    //update
    CategoryDto update(CategoryDto categoryDto,String categoryId);
    //delete
    void delete(String categoryId);
    //get all
    PageableResponse<CategoryDto> getAll(int pageNumber,int pageSize,String sortBy,String sortDir);

    //get single category detail
    CategoryDto get(String categoryId);

}

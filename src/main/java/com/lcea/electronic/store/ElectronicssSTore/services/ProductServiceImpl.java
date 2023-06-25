package com.lcea.electronic.store.ElectronicssSTore.services;

import com.lcea.electronic.store.ElectronicssSTore.dtos.PageableResponse;
import com.lcea.electronic.store.ElectronicssSTore.dtos.ProductDto;
import com.lcea.electronic.store.ElectronicssSTore.entities.Product;
import com.lcea.electronic.store.ElectronicssSTore.exceptions.ResourceNotFoundException;
import com.lcea.electronic.store.ElectronicssSTore.helper.Helper;
import com.lcea.electronic.store.ElectronicssSTore.reposistry.ProductReposistry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductReposistry productReposistry;
    @Autowired
    private ModelMapper mapper;
    @Override
    public ProductDto create(ProductDto productDto) {
        Product product= mapper.map(productDto, Product.class);
        //product id
//        String productId=UUID.randomUUID().toString();
//        product.setProductId(productId);
        //added
        product.setAddedDate(new Date());
        Product saveProduct = productReposistry.save(product);
        return mapper.map(saveProduct,ProductDto.class);
    }
    @Override
    public ProductDto update(ProductDto productDto, String productId) {
      Product product=productReposistry.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found od given Id.."));
      product.setTitle(productDto.getTitle());
      product.setDescription(productDto.getDescription());
      product.setPrice(productDto.getPrice());
      product.setDiscountPrice(productDto.getDiscountPrice());
      product.setQuantity(productDto.getQuantity());
      product.setLive(productDto.isLive());
      product.setStock(productDto.isStock());
      //save the entity
        Product updateProduct=productReposistry.save(product);
        return mapper.map(updateProduct,ProductDto.class);
    }
    @Override
    public void delete(String productId) {
        Product product=productReposistry.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found od given Id.."));
        productReposistry.delete(product);
    }
    @Override
    public ProductDto get(String productId) {
        Product product=productReposistry.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found od given Id.."));
        return mapper.map(product, ProductDto.class);
    }
    @Override
    public PageableResponse<ProductDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) :(Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        Page<Product> page=productReposistry.findAll(pageable);
        return Helper.getPageableResponse(page, ProductDto.class);
    }
    @Override
    public PageableResponse<ProductDto>  getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) :(Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        Page<Product> page=productReposistry.findByLiveTrue(pageable);
        return Helper.getPageableResponse(page, ProductDto.class);
    }
    @Override
    public PageableResponse<ProductDto> searchByTitle(String subTitle,int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) :(Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        Page<Product> page=productReposistry.findByTitleContaining(subTitle,pageable);
        return Helper.getPageableResponse(page, ProductDto.class);
    }
}

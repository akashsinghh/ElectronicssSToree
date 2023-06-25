package com.lcea.electronic.store.ElectronicssSTore.reposistry;

import com.lcea.electronic.store.ElectronicssSTore.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReposistry extends JpaRepository<Product,String> {
    //search
    Page<Product> findByTitleContaining(String title,Pageable pageable);
    Page<Product> findByLiveTrue(Pageable pageable);

}

package com.lcea.electronic.store.ElectronicssSTore.reposistry;

import com.lcea.electronic.store.ElectronicssSTore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}

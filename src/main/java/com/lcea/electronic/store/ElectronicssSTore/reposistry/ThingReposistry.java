package com.lcea.electronic.store.ElectronicssSTore.reposistry;

import com.lcea.electronic.store.ElectronicssSTore.entities.Thing;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ThingReposistry extends JpaRepository<Thing,Long> {
    Optional<Thing> findByEmail(String email);
    Optional<Thing>  findByEmailAndPassword(String email,String password);
    List<Thing> findByNameContaining(String keyword);
}

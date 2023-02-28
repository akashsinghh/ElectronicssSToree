package com.lcea.electronic.store.ElectronicssSTore.reposistry;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserReposistry extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
    Optional<User>  findByEmailAndPassword(String email,String password);
    List<User> findByNameContaining(String keyword);
}

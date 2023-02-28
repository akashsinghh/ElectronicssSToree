package com.lcea.electronic.store.ElectronicssSTore.services;

import com.lcea.electronic.store.ElectronicssSTore.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {
    UserDto createUSer(UserDto userDto);
    //update
    UserDto updateUser(UserDto userDto,String userId);
    //delete
    void deleteUser(String userId);
    //get all user
    List<UserDto> getAllUser();
    //get single user by id
    UserDto getUserById(String userId);
    //get single user by email
    UserDto getUserByEmail(String email);
    //search user
    List<UserDto> searchUsers(String keywords);
}

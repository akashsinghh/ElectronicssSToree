package com.lcea.electronic.store.ElectronicssSTore.services;

import com.lcea.electronic.store.ElectronicssSTore.dtos.PageableResponse;
import com.lcea.electronic.store.ElectronicssSTore.dtos.ThingDto;

import java.util.List;



public interface ThingService {
    ThingDto createUSer(ThingDto thingDto);
    //update
    ThingDto updateUser(ThingDto thingDto, Long userId);
    //delete
    void deleteUser(Long userId);
    //get all user
    PageableResponse<ThingDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir);
    //get single user by id
    ThingDto getUserById(Long userId);
        //get single user by email
    ThingDto getUserByEmail(String email);
    //search user
    List<ThingDto> searchUsers(String keywords);
}

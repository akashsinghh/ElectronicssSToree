package com.lcea.electronic.store.ElectronicssSTore.services;

import com.lcea.electronic.store.ElectronicssSTore.dtos.PageableResponse;
import com.lcea.electronic.store.ElectronicssSTore.dtos.ThingDto;
import com.lcea.electronic.store.ElectronicssSTore.entities.Thing;
import com.lcea.electronic.store.ElectronicssSTore.exceptions.ResourceNotFoundException;
import com.lcea.electronic.store.ElectronicssSTore.helper.Helper;
import com.lcea.electronic.store.ElectronicssSTore.reposistry.ThingReposistry;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import java.util.stream.Collectors;

@Service
public  class ThingServiceImpl implements ThingService {
    @Autowired
    private ThingReposistry thingReposistry;
    @Autowired
    private ModelMapper mapper;


    private Logger logger = LoggerFactory.getLogger(ThingServiceImpl.class);
    @Value("@{user.profile.image.path}")
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    private String imagePath;
    @Override
    public ThingDto createUSer(ThingDto thingDto) {
        //genrate unique id in string foramt
//        String userId = UUID.randomUUID().toString();
//        thingDto.setUserId(userId);
        //encoding password
//        thingDto.setPassword(passwordEncoder.encode(thingDto.getPassword()));


        //dto->entity
        Thing thing= (Thing) dtoToEntity(thingDto);

        Thing savedThing=thingReposistry.save(thing);
        //entity->dto
        ThingDto newDto=entityToDto(savedThing);

        return newDto;
    }

    @Override
    public ThingDto updateUser(ThingDto thingDto, Long userId) {
        Thing thing=thingReposistry.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException(" user not found exception"));
        thingDto.setName(thingDto.getName());
        thingDto.setAbout(thingDto.getAbout());
        thingDto.setGender(thingDto.getGender());
        thingDto.setPassword(thingDto.getPassword());
        thingDto.setImageName(thingDto.getImageName());

        //save data
        Thing updatedThing= thingReposistry.save(thing);
        ThingDto updateDto=entityToDto(updatedThing);
        return updateDto;
    }

    @Override
    public void deleteUser(Long userId) {
        Thing thing=thingReposistry.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException());

        //delete user profile image
        String fullpath = imagePath + thing.getImageName();
        try {
            Path path= Paths.get(fullpath);
            Files.delete(path);

        }catch (NoSuchFileException e) {
            logger.info("User image not found in folder ");
            e.printStackTrace();

        } catch (IOException e) {
           e.printStackTrace();
        }


        thingReposistry.delete(thing);

    }

    @Override
    public PageableResponse<ThingDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir) {
//      Sort sort=  Sort.by(sortBy);
        Sort sort=(sortDir.equalsIgnoreCase("desc")) ?
                (Sort.by(sortBy).descending()) :(Sort.by(sortBy)).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize,sort);
        Page<Thing> page=thingReposistry.findAll(pageable);
//        List<Thing> thing=page.getContent();
//      //  List<Thing> users=thingReposistry.findAll();
//        List<ThingDto> dtoList=thing.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
//        PageableResponse<ThingDto> response=new PageableResponse<>();
//        response.setContent(dtoList);
//        response.setPageNumber(page.getNumber());
//        response.setPageSize(page.getSize());
//        response.setTotalElements(page.getTotalElements());
//        response.setPageSize(page.getTotalPages());
//        response.setLastPage(page.isLast());
        PageableResponse<ThingDto> response = Helper.getPageableResponse(page, ThingDto.class);
        return response;
    }

    @Override
    public ThingDto getUserById(Long userId) {
        Thing thing=thingReposistry.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not found in given id"));
        return entityToDto(thing);
    }

    @Override
    public ThingDto getUserByEmail(String email) {
        Thing thing= thingReposistry.findByEmail(email).orElseThrow(()->
                new ResourceNotFoundException("user not found with given  id !!"));
        return entityToDto(thing);
    }

    @Override
    public List<ThingDto> searchUsers(String keywords) {
        List<Thing> thing= thingReposistry.findByNameContaining(keywords);
        List<ThingDto> dtoList=thing.stream().map(user -> entityToDto((Thing) thing)).collect(Collectors.toList());
        return dtoList;

    }

    //convert
    private ThingDto entityToDto(Thing savedThing) {
        return mapper.map(savedThing, ThingDto.class);
//       UserDto.builder()
//               .userId(savedUser.getU)
//       UserDto userDto= UserDto.builder()
//                .userId(savedUser.getUserId())
//                .name(savedUser.getName())
//                .email(savedUser.getEmail())
//                .password(savedUser.getPassword())
//                .about(savedUser.getName())
//                .gender(savedUser.getGender())
//                .imageName(savedUser.getImageName())
//                .build();


    }
    private Thing dtoToEntity(ThingDto thingDto) {
        return mapper.map(thingDto,Thing.class);
//        UserDto userDt=UserDto.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .about(userDto.getAbout())
//                .gender(userDto.getGender())
//                .imageName(userDto.getGender())
//


    }
}

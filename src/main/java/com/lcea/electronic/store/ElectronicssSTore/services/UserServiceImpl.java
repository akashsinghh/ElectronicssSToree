package com.lcea.electronic.store.ElectronicssSTore.services;

import com.lcea.electronic.store.ElectronicssSTore.dtos.UserDto;
import com.lcea.electronic.store.ElectronicssSTore.reposistry.UserReposistry;
import com.lcea.electronic.store.ElectronicssSTore.services.UserService;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public  class UserServiceImpl implements UserService {
    @Autowired
    private UserReposistry userReposistry;
    @Autowired
    private ModelMapper mapper;
    @Override
    public UserDto createUSer(UserDto userDto) {
        //genrate unique id in string foramt
        String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);

        //dto->entity
        User user=dtoToEntity(userDto);

        User savedUser=userReposistry.save(user);
        //entity->dto
        UserDto newDto=entityToDto(savedUser);

        return newDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user=userReposistry.findById(userId).orElseThrow(() -> new RuntimeException(" user not found exception"));
        userDto.setName(userDto.getName());
        userDto.setAbout(userDto.getAbout());
        userDto.setGender(userDto.getGender());
        userDto.setPassword(userDto.getPassword());
        userDto.setImageName(userDto.getImageName());

        //save data
        User updatedUser= userReposistry.save(user);
        UserDto updateDto=entityToDto(updatedUser);
        return updateDto;
    }

    @Override
    public void deleteUser(String userId) {
        User user=userReposistry.findById(userId).orElseThrow(() -> new RuntimeException(" user not found exception"));
        userReposistry.delete(user);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users=userReposistry.findAll();
        List<UserDto> dtoList=users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public UserDto getUserById(String userId) {
        User user=userReposistry.findById(userId).orElseThrow(()->new RuntimeException("User not found in given id"));
        return entityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user= userReposistry.findByEmail(email).orElseThrow(()->new RuntimeException("user not found with given  id and password"));
        return entityToDto(user);
    }

    @Override
    public List<UserDto> searchUsers(String keywords) {
        List<User> users= userReposistry.findByNameContaining(keywords);
        List<UserDto> dtoList=users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return dtoList;

    }

    //convert
    private UserDto entityToDto(User savedUser) {
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
        return mapper.map(savedUser,UserDto.class);

    }private User dtoToEntity(UserDto userDto) {
//        UserDto userDt=UserDto.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .about(userDto.getAbout())
//                .gender(userDto.getGender())
//                .imageName(userDto.getGender())
//

        return mapper.map(userDto,User.class);
    }
}

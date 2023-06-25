package com.lcea.electronic.store.ElectronicssSTore.controllers;

import com.lcea.electronic.store.ElectronicssSTore.dtos.ApiResponseMessage;
import com.lcea.electronic.store.ElectronicssSTore.dtos.ImageResponse;
import com.lcea.electronic.store.ElectronicssSTore.dtos.PageableResponse;
import com.lcea.electronic.store.ElectronicssSTore.dtos.ThingDto;
import com.lcea.electronic.store.ElectronicssSTore.entities.Thing;
import com.lcea.electronic.store.ElectronicssSTore.services.FileService;
import com.lcea.electronic.store.ElectronicssSTore.services.ThingService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping("/users")
public class ThingController {
    @Autowired
    private ThingService thingService;
    @Autowired
    private FileService fileService;
    private Logger logger= LoggerFactory.getLogger(ThingController.class);
    @Value("${user.profile.image.path}")
    private String imageUploadPath;
    //create

    @PostMapping
    public ResponseEntity<ThingDto> createUser(@Valid @RequestBody ThingDto thingDto){
        ThingDto thingDto1=thingService.createUSer(thingDto);
        return new ResponseEntity<>(thingDto1, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{userId}")
    public ResponseEntity<ThingDto> updateUser(
            @PathVariable("userId") Long userId,
         @Valid   @RequestBody ThingDto thingDto)
    {   ThingDto updateUserDto=thingService.updateUser(thingDto,userId);
        return new ResponseEntity<>(updateUserDto,HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable Long userId){
        thingService.deleteUser(userId);
        ApiResponseMessage message=ApiResponseMessage
                .builder()
                .message("User is deleted Successfully").
                success(true).
                status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    //get all
    @GetMapping
    public ResponseEntity<PageableResponse<ThingDto>> ugetAllUser(
            @RequestParam()
//            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
//            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
//            @RequestParam(value = "sortBy",defaultValue = "name",required = false) String sortBy,
//            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    ){
        return new ResponseEntity<>(thingService.getAllUser(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }
    // get single
    @GetMapping("/{userId}")
    public ResponseEntity<ThingDto> getUser(Long userId){
        return new ResponseEntity<>(thingService.getUserById(userId), HttpStatus.OK);
    }
    //get by email
    @GetMapping("/email/{email}")
    public ResponseEntity<ThingDto> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(thingService.getUserByEmail(email),HttpStatus.OK);
    }
    //search user
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<ThingDto>> searchUser(@PathVariable String keywords){
        return new ResponseEntity<>(thingService.searchUsers(keywords),HttpStatus.OK);
    }
    //upload image
    @PostMapping("/image/{userId}")
    public ResponseEntity<ImageResponse> uploadUserImage(@RequestParam("userImage") MultipartFile image
    ,@PathVariable Long userId) throws IOException {

        String imageName=fileService.uploadFile(image,imageUploadPath);
        ThingDto thingDto=thingService.getUserById(userId);
        thingDto.setImageName(imageName);
        ThingDto thingDTO=thingService.updateUser(thingDto,userId);
        ImageResponse imageResponse=ImageResponse.builder().imageName(imageName).success(true).status(HttpStatus.CREATED).build();
        return new ResponseEntity<>(imageResponse,HttpStatus.CREATED);
    }
    //serve user image
    @GetMapping("/image/{userId}")
    public void serveUserImage(@PathVariable Long userId, HttpServletResponse response) throws IOException {
      ThingDto thing=  thingService.getUserById(userId);
      logger.info("user image name : {} ",thing.getImageName());
      InputStream resource=fileService.getResource(imageUploadPath,thing.getImageName());
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      StreamUtils.copy(resource,response.getOutputStream());



    }


}


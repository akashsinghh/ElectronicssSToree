package com.lcea.electronic.store.ElectronicssSTore.dtos;

import com.lcea.electronic.store.ElectronicssSTore.validate.ImageNameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@ Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThingDto {
    private String userId;
    @Size(min = 3,max = 15,message = "Invalid !!")
    private String name;
    @Pattern(regexp ="^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+\\.)+[a-z]{2,5}$",message = "Invalid user mail")
//  @Email(message = "Invalid User Email !!")
    @NotBlank(message = "Password is required")
    private String email;
    @NotBlank(message = "Password is reqiured")
    private String password;
    @Size(min = 4,max = 6,message = "Invalid")
    private String gender;
    @NotBlank(message = "Write something about yourself")
    private String about;
    @ImageNameValid
    private String imageName;
}

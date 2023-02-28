package com.lcea.electronic.store.ElectronicssSTore.entities;

import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "userss")
public class Users {
    @Id
   // @GeneratedValue
    private String userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_mail",unique = true)
    private String email;
    @Column(name = "user_password",length = 10)
    private String password;

    private String gender;
    @Column(length = 10)
    private String about;
    @Column(name = "user_image_name")
    private String imageName;

}

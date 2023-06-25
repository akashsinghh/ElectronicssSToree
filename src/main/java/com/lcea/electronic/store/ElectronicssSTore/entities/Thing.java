package com.lcea.electronic.store.ElectronicssSTore.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "thing")
public class Thing {
    @Id
    @GeneratedValue
    private int userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_mail",unique = true)
    private String email;
    @Column(name = "user_password",length =500)
    private String password;
    private String gender;
    @Column(length = 1000)
    private String about;
    @Column(name = "user_image_name")
    private String imageName;


}

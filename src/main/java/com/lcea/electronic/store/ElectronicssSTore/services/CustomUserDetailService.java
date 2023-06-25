//package com.lcea.electronic.store.ElectronicssSTore.services;
//
//import com.lcea.electronic.store.ElectronicssSTore.entities.Thing;
//import com.lcea.electronic.store.ElectronicssSTore.reposistry.ThingReposistry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    private ThingReposistry thingReposistry;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       Thing thing= thingReposistry.findByEmail(username).orElseThrow(
//                ()-> new UsernameNotFoundException("User with given email not found !!"));
//        return thing;
//    }
//}

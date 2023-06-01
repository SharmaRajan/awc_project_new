package com.dalmia.crudapp.security.jwt;


import com.dalmia.crudapp.entity.User;
import com.dalmia.crudapp.repository.IUserRepo;
import com.dalmia.crudapp.serviceImpl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Primary
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepo.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        if(optionalUser.isPresent()){
            User dbUser = optionalUser.get();
            if(dbUser.getUsername().equals(username)){
                return UserDetailsImpl.build(dbUser);
            }
        }else{
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        /*if ("javainuse".equals(username)) {
            // username is javainuse and password is password
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } */
        return null;
    }
}

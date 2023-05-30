package com.dalmia.crudapp.serviceImpl;


import com.dalmia.crudapp.entity.UserNotWorking;
import com.dalmia.crudapp.repository.IUserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    IUserRepo userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String emailId, password = null;

        List<GrantedAuthority> authorities = null;

//        User user = userRepository.findByEmailId(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        System.out.println("Before user optional");

        System.out.println("Username: " + username);

//        Optional<User> userOptional = userRepository.findByEmail(username);
        Optional<UserNotWorking> userOptional = userRepository.findById(1L);


        System.out.println("After user optional");

//        Optional<User> userOptional = userRepository.findByUsername(username);

        if(!userOptional.isPresent()){
            throw new UsernameNotFoundException("User not found "+ username);
        }

        UserNotWorking userNotWorking = userOptional.get();

//        emailId = user.getEmailId();
//        password = user.getPassword();

        //return new User(emailId,password);

        return UserDetailsImpl.build(userNotWorking);
//        return new UserDetailsImpl(user);
    }
}

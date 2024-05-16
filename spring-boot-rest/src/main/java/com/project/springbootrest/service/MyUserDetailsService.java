package com.project.springbootrest.service;

import com.project.springbootrest.model.AppUsers;
import com.project.springbootrest.ropo.JobRepo;
import com.project.springbootrest.ropo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
//    private JobRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUsers> user = userRepo.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRole(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
    public String[] getRole(AppUsers appUser) {
        if (appUser.getRole() == null) {
            return new String[] {"USER"};
        } else {
            return appUser.getRole().split(",");
        }
    }
}

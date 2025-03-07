package com.CollabFusion.COLLABFUSIONPROEJCT.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CollabFusion.COLLABFUSIONPROEJCT.models.customerUser;
import com.CollabFusion.COLLABFUSIONPROEJCT.repositories.customerUserRepository;

@Service
public class customerUserService implements UserDetailsService {

    @Autowired
    private customerUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        customerUser customerUser = repo.findByEmail(email);
        if (customerUser == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return User.withUsername(customerUser.getEmail())
                .password(customerUser.getPassword())
                .roles(customerUser.getRole())
                .build();
    }

}

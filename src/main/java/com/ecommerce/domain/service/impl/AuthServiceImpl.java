package com.ecommerce.domain.service.impl;

import com.ecommerce.domain.service.AuthService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@Service
@CrossOrigin
public class AuthServiceImpl implements AuthService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User(s,"ECOMMERCE2024",new ArrayList<>());
    }
}

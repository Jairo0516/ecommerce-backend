package com.ecommerce.domain.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}

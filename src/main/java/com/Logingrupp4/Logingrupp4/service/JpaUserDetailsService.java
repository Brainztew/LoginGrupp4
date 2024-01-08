package com.Logingrupp4.Logingrupp4.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.Logingrupp4.Logingrupp4.model.UserDto;
import com.Logingrupp4.Logingrupp4.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    
    public JpaUserDetailsService(UserRepository userRepository) {
            this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .map(UserDto::new)
            .orElseThrow(() -> new UsernameNotFoundException("Hittade ingen användare"));
    }

}

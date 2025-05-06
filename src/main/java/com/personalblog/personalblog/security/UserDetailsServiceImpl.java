package com.personalblog.personalblog.security;

import com.personalblog.personalblog.model.User;
import com.personalblog.personalblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(userName);

        if (user.isPresent())
            return new UserDetailsImpl(user.get());
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

    }
}
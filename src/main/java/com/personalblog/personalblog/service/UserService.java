package com.personalblog.personalblog.service;

import java.util.Optional;

import com.personalblog.personalblog.dto.user.UserCreateDTO;
import com.personalblog.personalblog.dto.user.UserUpdateDTO;
import com.personalblog.personalblog.mapper.UserMapper;
import com.personalblog.personalblog.model.User;
import com.personalblog.personalblog.model.UserLogin;
import com.personalblog.personalblog.repository.UserRepository;
import com.personalblog.personalblog.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Optional<User> createUser(UserCreateDTO userCreateDTO) {

        if (userRepository.findByEmail(userCreateDTO.getEmail()).isPresent()) {
            return Optional.empty();
        }

        User user = UserMapper.toEntity(userCreateDTO);

        user.setPassword(encryptPassword(user.getPassword()));

        return Optional.of(userRepository.save(user));
    }

    public Optional<User> updateUser(UserUpdateDTO userUpdateDTO) {

        if(userRepository.findById(userUpdateDTO.getId()).isPresent()) {

            Optional<User> searchUser = userRepository.findByEmail(userUpdateDTO.getEmail());

            if ( searchUser.isPresent() && !searchUser.get().getId().equals(userUpdateDTO.getId()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists!", null);

            User user = UserMapper.toEntity(userUpdateDTO);

            user.setPassword(encryptPassword(user.getPassword()));

            return Optional.ofNullable(userRepository.save(user));

        }

        return Optional.empty();

    }

    public Optional<UserLogin> authenticateUser(Optional<UserLogin> userLogin) {

        if (userLogin.isEmpty()) return Optional.empty();

        // Gera o Objeto de autenticação
        var credentials = new UsernamePasswordAuthenticationToken(userLogin.get().getEmail(), userLogin.get().getPassword());

        // Autentica o Usuario
        Authentication authentication = authenticationManager.authenticate(credentials);

        // Se a autenticação foi efetuada com sucesso
        if (authentication.isAuthenticated()) {

            // Busca os dados do usuário
            Optional<User> user = userRepository.findByEmail(userLogin.get().getEmail());

            // Se o usuário foi encontrado
            if (user.isPresent()) {

                // Preenche o Objeto usuarioLogin com os dados encontrados
                userLogin.get().setId(user.get().getId());
                userLogin.get().setName(user.get().getName());
                userLogin.get().setPhoto(user.get().getPhoto());
                userLogin.get().setToken(generateToken(user.get().getEmail()));
                userLogin.get().setPassword("");

                // Retorna o Objeto preenchido
                return userLogin;

            }

        }

        return Optional.empty();

    }

    private String encryptPassword(String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(password);

    }

    private String generateToken(String user) {
        return "Bearer " + jwtService.generateToken(user);
    }

}
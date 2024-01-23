package com.example.Name.Spring.Security.studies.controller;

import com.example.Name.Spring.Security.studies.entities.User.AuthenticationDTO;
import com.example.Name.Spring.Security.studies.entities.User.LoginResponseDTO;
import com.example.Name.Spring.Security.studies.entities.User.User;
import com.example.Name.Spring.Security.studies.entities.User.registerDTO;
import com.example.Name.Spring.Security.studies.exception.LoginAlreadyExists;
import com.example.Name.Spring.Security.studies.exception.loginIncorrectException;
import com.example.Name.Spring.Security.studies.repository.UserRepository;
import com.example.Name.Spring.Security.studies.service.AuthorizationService;
import com.example.Name.Spring.Security.studies.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        try {
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        }catch(Exception e){
            throw new loginIncorrectException();
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid registerDTO data){
        if(userRepository.findByLogin(data.login()) != null){
            throw new LoginAlreadyExists();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword,data.role());
        userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.OK).build();
    }
}














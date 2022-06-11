package com.example.springbootrestapitest.controller.user;

import com.example.springbootrestapitest.dto.user.LoginDto;
import com.example.springbootrestapitest.dto.user.SignUpDto;
import com.example.springbootrestapitest.entity.Role;
import com.example.springbootrestapitest.entity.User;
import com.example.springbootrestapitest.repository.user.UserRepository;
import com.example.springbootrestapitest.repository.user.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {

        log.info("users signup, signUpDto: {}", signUpDto);

        if (userRepository.existsByName(signUpDto.getName())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        // create user object
        // test role : admin
        // 미리 roles table에 ROLE_USER, ROLE_ADMIN 기입해야
        Role roles = roleRepository.findByName("ROLE_USER").get();

        User user = User.builder()
                .name(signUpDto.getName())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .roles(Collections.singleton(roles))
                .build();

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(     // 인증
                new UsernamePasswordAuthenticationToken(
                        loginDto.getName(),
                        loginDto.getPassword()
                ));
        SecurityContext securityContext = SecurityContextHolder.getContext();   // 인가
        securityContext.setAuthentication(authentication);

        return new ResponseEntity<>("User signed in successfully!", HttpStatus.OK);
    }
}
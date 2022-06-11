package com.example.springbootrestapitest.service.user;

import com.example.springbootrestapitest.dto.user.PrincipalDetails;
import com.example.springbootrestapitest.entity.User;
import com.example.springbootrestapitest.exception.ResourceNotFoundException;
import com.example.springbootrestapitest.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username"));

        return new PrincipalDetails(user);
    }
}

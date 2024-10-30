package com.dibyendu.learning.service;


import com.dibyendu.learning.entiry.User;
import com.dibyendu.learning.model.SignUpRequest;
import com.dibyendu.learning.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Found with email: " + username));
    }

    public boolean existsByEmail(String email) {
        return this.userRepository.findByEmail(email).isPresent();
    }

    public void createUser(SignUpRequest signUpRequest){
        User user = User.builder()
                .firstname(signUpRequest.getFirstname())
                .lastname(signUpRequest.getLastname())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .phoneNo(signUpRequest.getPhone())
                .sex(signUpRequest.getSex())
                .dob(LocalDate.parse(signUpRequest.getDob()))
                .isActive(true)
                .address(signUpRequest.getAddress())
                .build();
        userRepository.save(user);
    }
}

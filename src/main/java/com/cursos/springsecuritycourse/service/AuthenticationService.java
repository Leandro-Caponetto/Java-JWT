package com.cursos.springsecuritycourse.service;

import com.cursos.springsecuritycourse.dto.AuthenticationResponse;
import com.cursos.springsecuritycourse.dto.AuthenticationResquest;
import com.cursos.springsecuritycourse.entity.User;
import com.cursos.springsecuritycourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    public AuthenticationResponse login(AuthenticationResquest authRequest) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()
        );
        authenticationManager.authenticate(authToken);

        User user = userRepository.findByUsername(authRequest.getUsername()).get();


        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        

        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object > generateExtraClaims(User user) {
    }
}

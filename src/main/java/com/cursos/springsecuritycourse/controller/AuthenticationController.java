package com.cursos.springsecuritycourse.controller;


import com.cursos.springsecuritycourse.dto.AuthenticationResponse;
import com.cursos.springsecuritycourse.dto.AuthenticationResquest;
import com.cursos.springsecuritycourse.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationResquest authRequest){
        AuthenticationResponse jwtDto = authenticationService.login(authRequest);

        return ResponseEntity.ok(jwtDto);
    }

    @GetMapping("/public-access")
    public String publicAccessEndpoint(){
        return "Este endpoint es público";
    }
}

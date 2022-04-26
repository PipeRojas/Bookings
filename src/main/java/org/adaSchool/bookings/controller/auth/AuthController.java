package org.adaSchool.bookings.controller.auth;

import org.adaSchool.bookings.controller.security.JWTGenerate;
import org.adaSchool.bookings.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/auth")
public class AuthController {

    public AuthController() {
    }
    @Autowired
    JWTGenerate jwtGenerate;
    @Autowired
    UserDetailsService userDetailsService;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String jwt;
        if(user.getPassword().equals(request.getPassword())){
            jwt = jwtGenerate.generateToken(user);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }else {
            throw new InvalidCredentialsException();
        }
    }
}

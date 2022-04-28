package org.adaSchool.bookings.controller.auth;

import org.adaSchool.bookings.controller.security.JWTGenerate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthControllerTest {
    private static final String TOKEN  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    @InjectMocks
    private final AuthController _controller=new AuthController();;

    @Mock
    private JWTGenerate jwtGenerate;

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private UserDetails _user;

    private AuthenticationRequest _request;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        _request = new AuthenticationRequest();
        _request.setUsername("Felipe");
        _request.setPassword("7@CQbgNS9FsR%3d");
    }

    @Test
    void login() {
        //Arrange
        when(userDetailsService.loadUserByUsername("Felipe")).thenReturn(_user);
        when(_user.getPassword()).thenReturn("7@CQbgNS9FsR%3d");
        when(jwtGenerate.generateToken(_user)).thenReturn(TOKEN);

        //Act
        ResponseEntity<AuthenticationResponse> response = this._controller.login(_request);

        //Assert
        assertEquals(TOKEN,response.getBody().getJwt());
    }
}
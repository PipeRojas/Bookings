package org.adaSchool.bookings.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class UserSecurityDetailServiceTest {

    private UserSecurityDetailService _service;

    @BeforeEach
    void setUp() {
        _service = new UserSecurityDetailService();
    }

    @Test
    void loadUserByUsername_Succeed() {
        //Act
        UserDetails response = _service.loadUserByUsername(anyString());

        //Assert
        assertNotNull(response);
        assertEquals(response.getUsername(),"Felipe");
        assertEquals(response.getPassword(),"123");
    }
}
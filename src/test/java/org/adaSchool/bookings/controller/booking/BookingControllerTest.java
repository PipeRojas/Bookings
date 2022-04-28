package org.adaSchool.bookings.controller.booking;

import org.adaSchool.bookings.controller.booking.dto.BookingDTO;
import org.adaSchool.bookings.repository.model.Booking;
import org.adaSchool.bookings.service.IBookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class BookingControllerTest {

    @InjectMocks
    private BookingController _controller;

    @Mock
    private IBookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this._controller = new BookingController(bookingService);
    }

    @Test
    void testCreate() {
        //Arrange
        Booking expected = new Booking();
        BookingDTO request = new BookingDTO();
        when(bookingService.create(new Booking(request))).thenReturn(new Booking());

        //Act
        ResponseEntity<Booking> response = this._controller.create(new BookingDTO());

         assertEquals(expected,response.getBody());
    }

    @Test
    void testGetAll() {
        //Arrange
        List<Booking> expected = new ArrayList<Booking>();
        when(bookingService.getAll()).thenReturn(expected);

        //Act
        ResponseEntity<List<Booking>> response = this._controller.all();

        //Assert
        assertEquals(expected.size(),response.getBody().size());
    }

    @Test
    void findById() {
        //Arrange
        Optional<Booking> expected = Optional.of(new Booking());
        when(bookingService.findById(anyString())).thenReturn(expected);

        //Act
        ResponseEntity<Optional<Booking>> response = this._controller.findById(anyString());

        //Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(expected.get(),response.getBody().get());
    }
}
package org.adaSchool.bookings.service;

import org.adaSchool.bookings.repository.IBookingMongoDBRepository;
import org.adaSchool.bookings.repository.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.swing.text.html.Option;
import java.awt.print.Book;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class BookingServiceMongoDBImplTest {
    private Booking _book;

    @InjectMocks
    private BookingServiceMongoDBImpl _service;

    @Mock
    private IBookingMongoDBRepository _mongoDBRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        _service = new BookingServiceMongoDBImpl(_mongoDBRepository);
        _book = new Booking("akjffaflal","Flight reservation",new Date(),new Date(),
                new Date(),true,null,4);

        when(_mongoDBRepository.findById(anyString())).thenReturn(Optional.of(_book));
    }

    @Test
    void testCreate_NotNull() {
        //Arrange
        when(this._mongoDBRepository.save(_book)).thenReturn(_book);

        //Act
        Booking response = _service.create(_book);

        //Assert
        assertNotNull(response);
        assertEquals(_book,response);
    }

    @Test
    void getAll() {
        //Arrange
        when(_mongoDBRepository.findAll()).thenReturn(Collections.emptyList());

        //Act
        List<Booking> response = _service.getAll();

        //Assert
        assertNotNull(response);
        assertEquals(0,response.size());
    }

    @Test
    void findById() {
        //Act
        Optional<Booking> response = _service.findById("aaa");

        //Assert
        assertNotNull(response);
        assertEquals(_book,response.get());
    }

    @Test
    void update() {
        //Arrange
        when(_mongoDBRepository.save(any(Booking.class))).thenReturn(_book);

        //Act
        Optional<Booking> response = _service.update(_book);

        //Assert
        assertNotNull(response);
        assertEquals(_book,response.get());
    }

    @Test
    void delete() {
        //Arrange
        doNothing().when(_mongoDBRepository).delete(any(Booking.class));

        //Act
        Optional<Booking> response = _service.delete(_book);

        //Assert
        assertNotNull(response);
        assertTrue(response.isPresent());
        assertEquals(_book,response.get());
    }
}
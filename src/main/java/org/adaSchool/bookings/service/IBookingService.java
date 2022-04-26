package org.adaSchool.bookings.service;

import org.adaSchool.bookings.repository.model.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingService {

    Booking create(Booking booking);

    List<Booking> getAll();

    Optional<Booking> findById(String id);

    Optional<Booking> update(Booking booking);

    Optional<Booking> delete(Booking booking);
}

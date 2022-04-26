package org.adaSchool.bookings.service;

import org.adaSchool.bookings.repository.IBookingMongoDBRepository;
import org.adaSchool.bookings.repository.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceMongoDBImpl implements IBookingService{
    IBookingMongoDBRepository mongoDBRepository;

    public BookingServiceMongoDBImpl(@Autowired IBookingMongoDBRepository mongoDBRepository) {
        this.mongoDBRepository = mongoDBRepository;
    }

    @Override
    public Booking create(Booking booking) {
        return mongoDBRepository.save(booking);
    }

    @Override
    public List<Booking> getAll() {
        return mongoDBRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(String id) {
        return mongoDBRepository.findById(id);
    }

    @Override
    public Optional<Booking> update(Booking booking) {
        Optional<Booking> ans = mongoDBRepository.findById(booking.getId());
        ans.ifPresent(value -> mongoDBRepository.save(value));
        return ans;
    }

    @Override
    public Optional<Booking> delete(Booking booking) {
        Optional<Booking> ans = mongoDBRepository.findById(booking.getId());
        ans.ifPresent(value -> mongoDBRepository.delete(booking));
        return ans;
    }
}

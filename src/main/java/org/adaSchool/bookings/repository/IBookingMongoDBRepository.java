package org.adaSchool.bookings.repository;

import org.adaSchool.bookings.repository.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingMongoDBRepository extends MongoRepository<Booking, String> {
}

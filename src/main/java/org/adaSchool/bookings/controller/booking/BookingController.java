package org.adaSchool.bookings.controller.booking;

import org.adaSchool.bookings.controller.booking.dto.BookingDTO;
import org.adaSchool.bookings.repository.model.Booking;
import org.adaSchool.bookings.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {
    IBookingService bookingService;

    public BookingController(@Autowired IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody BookingDTO bookingDTO){
        return ResponseEntity.ok(bookingService.create(new org.adaSchool.bookings.repository.model.Booking(bookingDTO)));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> all(){return ResponseEntity.ok(bookingService.getAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Booking>> findById(@PathVariable String id){return ResponseEntity.ok(bookingService.findById(id));}

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Booking>> updateById(@PathVariable String id, @RequestBody BookingDTO bookingDTO){
        Optional<Booking> ans = bookingService.findById(id);
        ans.ifPresent(value -> bookingService.update(value.update(bookingDTO)));
        return ResponseEntity.ok(ans);
    }

    @DeleteMapping()
    public ResponseEntity<Optional<Booking>> delete(@RequestBody Booking booking){return ResponseEntity.ok(bookingService.delete(booking));}
}

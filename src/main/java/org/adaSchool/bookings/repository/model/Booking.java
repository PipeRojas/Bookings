package org.adaSchool.bookings.repository.model;

import org.adaSchool.bookings.controller.booking.dto.BookingDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document("booking")
public class Booking implements Serializable {
    @Id
    private String id;
    private String service;
    private Date startDatetime;
    private Date endDatetime;
    private Date bookingDatetime;
    private Boolean isActive;
    private String description;
    private Integer usersQuantity;

    public Booking() {
    }

    public Booking(String id, String service, Date startDatetime, Date endDatetime, Date bookingDatetime, Boolean isActive, String description, Integer usersQuantity) {
        this.id = id;
        this.service = service;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.bookingDatetime = bookingDatetime;
        this.isActive = isActive;
        this.description = description;
        this.usersQuantity = usersQuantity;
    }

    public Booking(BookingDTO bookingDTO) {
        this.service = bookingDTO.getService();
        this.startDatetime = bookingDTO.getStartDatetime();
        this.endDatetime = bookingDTO.getEndDatetime();
        this.bookingDatetime = bookingDTO.getBookingDatetime();
        this.isActive = bookingDTO.getActive();
        this.description = bookingDTO.getDescription();
        this.usersQuantity = bookingDTO.getUsersQuantity();
    }

    public Booking update(BookingDTO bookingDTO){
        this.service = bookingDTO.getService();
        this.startDatetime = bookingDTO.getStartDatetime();
        this.endDatetime = bookingDTO.getEndDatetime();
        this.bookingDatetime = bookingDTO.getBookingDatetime();
        this.isActive = bookingDTO.getActive();
        this.description = bookingDTO.getDescription();
        this.usersQuantity = bookingDTO.getUsersQuantity();
        return this;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Date getBookingDatetime() {
        return bookingDatetime;
    }

    public void setBookingDatetime(Date bookingDatetime) {
        this.bookingDatetime = bookingDatetime;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUsersQuantity() {
        return usersQuantity;
    }

    public void setUsersQuantity(Integer usersQuantity) {
        this.usersQuantity = usersQuantity;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(service, booking.service) && Objects.equals(startDatetime, booking.startDatetime) && Objects.equals(endDatetime, booking.endDatetime) && Objects.equals(bookingDatetime, booking.bookingDatetime) && Objects.equals(isActive, booking.isActive) && Objects.equals(description, booking.description) && Objects.equals(usersQuantity, booking.usersQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, service, startDatetime, endDatetime, bookingDatetime, isActive, description, usersQuantity);
    }
}

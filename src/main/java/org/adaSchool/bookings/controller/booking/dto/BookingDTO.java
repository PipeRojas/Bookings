package org.adaSchool.bookings.controller.booking.dto;

import java.util.Date;

public class BookingDTO {
    private String service;
    private Date startDatetime;
    private Date endDatetime;
    private Date bookingDatetime;
    private Boolean isActive;
    private String description;
    private Integer usersQuantity;

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

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof BookingDTO)) {
            return false;
        }

        BookingDTO b = (BookingDTO) o;
        return this.bookingDatetime == b.getBookingDatetime() &&
                this.isActive == b.getActive() &&
                this.description == b.getDescription() &&
                this.endDatetime == b.getEndDatetime() &&
                this.service == b.getService() &&
                this.startDatetime == b.getStartDatetime() &&
                this.usersQuantity == b.getUsersQuantity();
    }
}

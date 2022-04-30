# Bookings

______

URL: https://restbookings.herokuapp.com

## Bookings API REST

Data type handled: ***JSON***

###Resources

This API offers the followings main resources:

- bookings
- authenticate

These can be used alone like this:

| Resource | Method | Description | Parameter | Return |
| :------ | :----- | :---------- | :-------- | :------ |
| `/v1/booking` | **POST** | Save a new booking | **BookingDTO** | **Booking** |
| `/v1/booking` | **GET** | Returns all the registered bookings | | **List < Booking >** |
| `/v1/booking` | **DELETE** | Delete requested booking | **Booking** | **List < Booking >** |
| `/auth/authenticate` | **POST** | Authenticates an user to make use of any other resource (At the moment there's only one user available: User: Felipe Password: 123) | **AuthenticationRequest** | **jwt** |

### Resources Components

| Resource | Method | Description | Parameter | Return |
| :------ | :----- | :---------- | :-------- | :------ |
| `/v1/booking/{id}` | **GET** | Returns the requested booking | | **Optional < Booking >** |
| `/v1/booking/{id}` | **PUT** | Updates the requested booking | **BookingDTO** | **Optional < Booking >** |

### URL Parameters

| Name | Type | Description |
| :----- | :--- | :---------- |
| *id* | **String**| Id of the booking to process |

### Data Form

#### BookingDTO:

    {
        "service": String,
        "startDatetime": Date,
        "endDatetime": Date,
        "bookingDatetime": Date,
        "description": String,
        "usersQuantity": Integer,
        "active": Boolean
    }
    
#### Booking:

    {
        "id": String,
        "service": String,
        "startDatetime": Date,
        "endDatetime": Date,
        "bookingDatetime": Date,
        "description": String,
        "usersQuantity": Integer,
        "active": Boolean
    }

#### AuthenticationRequest:

    {
        "username":String,
        "password":String
    }

_________

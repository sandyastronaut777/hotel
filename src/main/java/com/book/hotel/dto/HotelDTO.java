package com.book.hotel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO {
    private int id;
    private int rooms;
    private double rating;
    private String name;
    private String phone;
    private String city;
    private String address;
    private String roomStatus;
    private double cost;
    private String roomType;
}

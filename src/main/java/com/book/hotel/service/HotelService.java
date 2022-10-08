package com.book.hotel.service;

import com.book.hotel.dto.HotelDTO;
import com.book.hotel.entity.Hotel;
import com.book.hotel.utility.APIResponse;

import java.util.List;

public interface HotelService {
    HotelDTO get(int id);

    APIResponse create(HotelDTO hotelDTO);

    APIResponse getHotel();

    APIResponse update(int id, HotelDTO hotelDTO);

    APIResponse delete(int id);

    List<Hotel> getN(String name);

    List<Hotel> getC(String city);

    List<Hotel> getR(float rating);

    List<Hotel> getRs(int rooms);

}


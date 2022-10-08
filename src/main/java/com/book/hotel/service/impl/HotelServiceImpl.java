package com.book.hotel.service.impl;

import com.book.hotel.dto.HotelDTO;
import com.book.hotel.entity.Hotel;
import com.book.hotel.repo.HotelRepository;
import com.book.hotel.service.HotelService;
import com.book.hotel.utility.APIResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public HotelDTO get(int id) {
        Hotel hotel = hotelRepository.findById(id);
        return getHotelDTO(hotel);
    }

    @Override
    public APIResponse create(HotelDTO hotelDTO) {
        Hotel s = getHotelEntity(hotelDTO);
        Hotel hotel=hotelRepository.save(s);
        return new APIResponse("success",hotel);
    }

    @Override
    public APIResponse getHotel() {
        List<Hotel> l = hotelRepository.findAll();
        List<HotelDTO> newList = new ArrayList<>();
        if ((!l.isEmpty())) {
            newList = l.stream().map(this::getHotelDTO).collect(Collectors.toList());
        }
        return new APIResponse("success", newList);
    }


    @Override
    public APIResponse update(int id, HotelDTO hotelDTO) {
        Hotel hotel = hotelRepository.findById(id);
        hotelRepository.save(hotel);
        return new APIResponse("success", id);
    }

    @Override
    public APIResponse delete(int id) {
        Hotel hotel = hotelRepository.findById(id);
        hotelRepository.delete(hotel);
        return new APIResponse("success", "hotel detail deleted successfully!");
    }

    @Override
    public List<Hotel> getN(String name) {
        List<Hotel> hotel = hotelRepository.findByName(name);
        return hotel;
    }

    @Override
    public List<Hotel> getC(String city) {
        List<Hotel> hotel = hotelRepository.findByCity(city);
        return hotel;
    }

    @Override
    public List<Hotel> getR(float rating) {
        List<Hotel> hotel = hotelRepository.findByRating(rating);
        return hotel;
    }

    @Override
    public List<Hotel> getRs(int rooms) {
        List<Hotel> hotel = hotelRepository.findByRooms(rooms);
        return hotel;
    }

    private Hotel getHotelEntity(HotelDTO hotelDTO) {
        return  mapper.convertValue(hotelDTO, Hotel.class);
    }

    private HotelDTO getHotelDTO(Hotel hotel) {
        return mapper.convertValue(hotel, HotelDTO.class);
    }

}
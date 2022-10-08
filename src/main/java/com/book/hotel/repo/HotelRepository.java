package com.book.hotel.repo;

import com.book.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    Hotel findById(int id);
    List<Hotel> findByName(String name);
    List<Hotel> findByCity(String phone);

    List<Hotel> findByRating(float rating);

    List<Hotel> findByRooms(int rooms);
}

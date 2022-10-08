package com.book.hotel.repo;

import com.book.hotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);
    List<User> findByName(String name);
    List<User> findByGender(String gender);

}

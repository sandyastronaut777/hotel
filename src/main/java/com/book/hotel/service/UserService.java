package com.book.hotel.service;

import com.book.hotel.dto.UserDTO;
import com.book.hotel.entity.User;
import com.book.hotel.utility.APIResponse;

import java.util.List;

public interface UserService {

    UserDTO get(int id);

    APIResponse create(UserDTO userDTO);

    APIResponse getUser();

    APIResponse update(int id, UserDTO userDTO);

    APIResponse delete(int id);

    List<User> getN(String name);

    List<User> getG(String gender);

}

package com.book.hotel.service.impl;

import com.book.hotel.dto.UserDTO;
import com.book.hotel.entity.User;
import com.book.hotel.repo.UserRepository;
import com.book.hotel.service.UserService;
import com.book.hotel.utility.APIResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserRepository userRepository;

    @Override
    public APIResponse create(UserDTO userDTO) {
        User s = getUserEntity(userDTO);
        User user = userRepository.save(s);
        return new APIResponse("success", user);
    }
    @Override
    public UserDTO get(int id) {
        User user = userRepository.findById(id);
        return getUserDTO(user);
    }

    @Override
    public APIResponse getUser() {
        List<User> l = userRepository.findAll();
        List<UserDTO> newList = new ArrayList<>();
        if ((!l.isEmpty())) {
            newList = l.stream().map(this::getUserDTO).collect(Collectors.toList());
        }
        return new APIResponse("success", newList);
    }


    @Override
    public APIResponse update(int id, UserDTO userDTO) {
        User user = userRepository.findById(id);
        userRepository.save(user);
        return new APIResponse("success", id);
    }

    @Override
    public APIResponse delete(int id) {
        User user = userRepository.findById(id);
        userRepository.delete(user);
        return new APIResponse("success", "user detail deleted successfully!");
    }

    @Override
    public List<User> getN(String name) {
        List<User> user = userRepository.findByName(name);
        return user;
    }


    @Override
    public List<User> getG(String gender) {
        List<User> user = userRepository.findByGender(gender);
        return user;
    }

    private User getUserEntity(UserDTO userDTO) {
        return  mapper.convertValue(userDTO, User.class);
    }

    private UserDTO getUserDTO(User user) {
        return mapper.convertValue(user, UserDTO.class);
    }
}

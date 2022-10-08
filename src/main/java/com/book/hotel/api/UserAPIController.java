package com.book.hotel.api;

import com.book.hotel.dto.UserDTO;
import com.book.hotel.entity.User;
import com.book.hotel.service.UserService;
import com.book.hotel.utility.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*")
public class UserAPIController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/create", produces = {"application/json"})
    APIResponse create(@RequestBody UserDTO userDTO){
        return userService.create(userDTO);
    }

    @GetMapping(value = "/get/{id}", produces = {"application/json"})
    public ResponseEntity<UserDTO> get (@PathVariable(value = "id", required = true) int id)
    {
        return ResponseEntity.ok(userService.get(id));
    }

    @GetMapping("/get")
    APIResponse getUser(){
        return userService.getUser();
    }

    @PostMapping("/update/{id}")
    APIResponse update(@PathVariable(required = true) int id, @RequestBody UserDTO userDTO){
        return userService.update(id, userDTO);
    }

    @DeleteMapping("/delete/{id}")
    APIResponse delete(@PathVariable(value = "id", required = true) int id){
        return userService.delete(id);
    }

    @GetMapping("/getN")    //QueryParam
    ResponseEntity<List<User>> getN(@RequestParam(name = "name") String name){
        return ResponseEntity.ok(userService.getN(name));
    }

    @GetMapping("/getG")    //QueryParam
    ResponseEntity<List<User>> getG(@RequestParam(value = "gender") String gender){
        return ResponseEntity.ok(userService.getG(gender));
    }

}

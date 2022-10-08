package com.book.hotel.api;

import com.book.hotel.dto.HotelDTO;
import com.book.hotel.entity.Hotel;
import com.book.hotel.service.HotelService;
import com.book.hotel.utility.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hotel")
@RestController
@CrossOrigin(origins = "*")
public class HotelAPIController {

    @Autowired
    HotelService hotelService;

    @GetMapping(value = "/get/{id}", produces = {"application/json"})   //Working 11:35AM 07-1022
    public ResponseEntity<HotelDTO> get (@PathVariable(value = "id", required = true) int id)
    {
        return ResponseEntity.ok(hotelService.get(id));
    }
    @PostMapping(value = "/create", produces = {"application/json"})   //Working  11:35AM 07-1022
    APIResponse create(@RequestBody HotelDTO hotelDTO){
        return hotelService.create(hotelDTO);
    }

    @GetMapping("/get")      //Working  11:35AM 07-1022
    APIResponse getHotel(){
        return hotelService.getHotel();
    }

    @PostMapping("/update/{id}")
    APIResponse update(@PathVariable(required = true) int id, @RequestBody HotelDTO hotelDTO){
        return hotelService.update(id, hotelDTO);
    }

    @DeleteMapping("/delete/{id}")
    APIResponse delete(@PathVariable(value = "id", required = true) int id){
        return hotelService.delete(id);
    }

    @GetMapping("/getN")    //QueryParam
    ResponseEntity<List<Hotel>> getN(@RequestParam(name = "name") String name){      //Working 11:37AM 07-10-22
        return ResponseEntity.ok(hotelService.getN(name));
    }

    @GetMapping("/getC")    //QueryParam
    ResponseEntity<List<Hotel>> getC(@RequestParam(value = "city") String city){     //Working 11:38AM 07-10-22
        return ResponseEntity.ok(hotelService.getC(city));
    }

    @GetMapping("/getR")    //QueryParam
    ResponseEntity<List<Hotel>> getR(@RequestParam(value = "rating") float rating){   //Working 11:44AM 07-10-22
        return ResponseEntity.ok(hotelService.getR(rating));
    }

    @GetMapping("/getRs")    //QueryParam
    ResponseEntity<List<Hotel>> getRs(@RequestParam(value = "rooms") int rooms){     //Working 11:38AM 07-10-22
        return ResponseEntity.ok(hotelService.getRs(rooms));
    }

}

package com.makemytour.controller;

import com.makemytour.payload.GuideDto;
import com.makemytour.payload.ResturantDto;
import com.makemytour.service.impl.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resturant")
public class ResturantController {

    @Autowired
    private ResturantService resturantService;

    //http://localhost:8080/api/resturant/addresturant/1
    @PostMapping("/addresturant/{id}")
    public ResponseEntity<ResturantDto> addResturant(@RequestBody ResturantDto resturantDto, @PathVariable long id) {
        ResturantDto resturant = resturantService.addResturant(resturantDto,id);
        return new ResponseEntity<>(resturant, HttpStatus.CREATED);


    }
}

package com.makemytour.controller;

import com.makemytour.entity.TouristPoint;
import com.makemytour.payload.TouristPointDto;
import com.makemytour.repository.TouristPointRepository;
import com.makemytour.service.impl.TouristPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tour")
public class TouristPointController {

    @Autowired
    private TouristPointService touristPointService;

    //http://localhost:8080/api/tour/tourist-points
    @PostMapping("/tourist-points")
    public ResponseEntity<TouristPointDto> createTouristPoint(@RequestBody TouristPointDto touristPointDto) {
        TouristPointDto touristPoint = touristPointService.createTouristPoint(touristPointDto);
        return new ResponseEntity<>(touristPoint,HttpStatus.CREATED);
    }

    //http://localhost:8080/api/tour/tourist-points/1
    @GetMapping("/tourist-points/{id}")
    public ResponseEntity<TouristPointDto> getTouristPoint(@PathVariable Long id) {
        TouristPointDto touristPointDto = touristPointService.getTouristPoint(id);
        if (touristPointDto != null) {
            return new ResponseEntity<>(touristPointDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/api/tour/tourist-points/1
    @PutMapping("/tourist-points/{id}")
    public ResponseEntity<TouristPointDto> updateTouristPoint(@PathVariable Long id, @RequestBody TouristPointDto dto){
        TouristPointDto dto1 = touristPointService.updateTouristPoint(id, dto);
        return new ResponseEntity<>(dto1,HttpStatus.OK);
    }




}

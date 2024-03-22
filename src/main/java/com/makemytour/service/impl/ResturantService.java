package com.makemytour.service.impl;

import com.makemytour.entity.Guide;
import com.makemytour.entity.Resturant;
import com.makemytour.entity.TouristPoint;
import com.makemytour.exception.ResourceNotFoundException;
import com.makemytour.payload.GuideDto;
import com.makemytour.payload.ResturantDto;
import com.makemytour.repository.ResturantRepository;
import com.makemytour.repository.TouristPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResturantService {

    @Autowired
    private ResturantRepository resturantRepository;

    @Autowired
    private TouristPointRepository touristPointRepository;

    public ResturantDto addResturant(ResturantDto resturantDto, long id) {
            TouristPoint touristPoint = touristPointRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Invalid Tourist Point")
            );

        Resturant resturant = new Resturant();
        resturant.setName(resturantDto.getName());
        resturant.setAddress(resturantDto.getAddress());
        resturant.setMobile(resturantDto.getMobile());
        resturant.setTouristPoint(touristPoint);

        Resturant savedResturant = resturantRepository.save(resturant);

        ResturantDto dto = new ResturantDto();
        dto.setName(savedResturant.getName());
        dto.setAddress(savedResturant.getAddress());
        dto.setMobile(savedResturant.getMobile());
        dto.setTouristPoint(savedResturant.getTouristPoint());
        return dto;

    }
}

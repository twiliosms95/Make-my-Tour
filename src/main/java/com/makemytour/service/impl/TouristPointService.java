package com.makemytour.service.impl;

import com.makemytour.entity.*;
import com.makemytour.exception.ResourceNotFoundException;
import com.makemytour.payload.TouristPointDto;
import com.makemytour.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristPointService {

    @Autowired
    private TouristPointRepository touristPointRepository;
    @Autowired
    private CabRepository cabRepository;

    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ResturantRepository resturantRepository;



    public TouristPointDto createTouristPoint(TouristPointDto touristPointDto) {
        TouristPoint touristPoint = new TouristPoint();
        touristPoint.setName(touristPointDto.getName());
        touristPoint.setAddress(touristPointDto.getAddress());

        List<Cab> allCabs = cabRepository.findAll();
        touristPoint.setCabs(allCabs);

        List<Guide> allGuides = guideRepository.findAll();
        touristPoint.setGuides(allGuides);

        List<Hotel> allHotels = hotelRepository.findAll();
        touristPoint.setHotels(allHotels);

        List<Resturant> allResturants = resturantRepository.findAll();
        touristPoint.setResturants(allResturants);


        TouristPoint savedtourist = touristPointRepository.save(touristPoint);
        TouristPointDto dto = new TouristPointDto();
        dto.setName(savedtourist.getName());
        dto.setAddress(savedtourist.getAddress());
        return dto;
    }


    public TouristPointDto getTouristPoint(Long id) {
        TouristPoint touristPoint = touristPointRepository.findById(id).orElseThrow(
                    ()-> new ResourceNotFoundException("Record Not Found with id:"+ id)
        );

        if (touristPoint != null) {
            TouristPointDto touristPointDto = new TouristPointDto();
            BeanUtils.copyProperties(touristPoint, touristPointDto);
            return touristPointDto;
        } else {
            return null;
        }
    }


    public TouristPointDto updateTouristPoint(Long id, TouristPointDto updatedTouristPointDto) {
        TouristPoint existingTouristPoint = touristPointRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record Not Found with id:"+ id)
        );

        return null;

    }


}

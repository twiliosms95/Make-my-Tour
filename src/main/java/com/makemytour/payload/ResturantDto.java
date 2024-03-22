package com.makemytour.payload;

import com.makemytour.entity.TouristPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResturantDto {

    private String name;
    private String address;
    private String mobile;

    private TouristPoint touristPoint;
}

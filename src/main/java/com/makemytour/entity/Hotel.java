package com.makemytour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String hotelname;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;


    @OneToOne
    @JsonIgnore
    private TouristPoint touristPoint;

}
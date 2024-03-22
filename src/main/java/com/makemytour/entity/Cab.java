package com.makemytour.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cab")
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cabnumber", nullable = false, unique = true)
    private String cabnumber;

    @Column(name = "drivername")
    private String drivername;

    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;

    @OneToOne
    @JsonIgnore
    private TouristPoint touristPoint;

}
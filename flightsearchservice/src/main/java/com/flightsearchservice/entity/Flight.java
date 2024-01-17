package com.flightsearchservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String flightNo;

  //  private int seatCapacity;

    // Below code will be used to manage the fields at runtime
/*
    @ElementCollection
    @CollectionTable(name = "flight_other_properties", joinColumns = @JoinColumn(name = "flight_id"))
    @MapKeyColumn(name = "property_key")
    @Column(name = "property_value")
    private Map<String, Object> otherProperties = new HashMap<>();

 */
}


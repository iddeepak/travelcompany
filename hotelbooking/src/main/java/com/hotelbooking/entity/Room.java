package com.hotelbooking.entity;

import com.hotelbooking.enums.RoomType;
import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private RoomType roomType;

    // Other room details (e.g., price, capacity)

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

//    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Booking> bookings = new ArrayList<>();
//
}

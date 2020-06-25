package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "segment")
public class Segment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "segmentId")
    private Long segmentId;

    @Column(name = "departureDateTime")
    private String departureDateTime;

    @Column(name = "arrivalDateTime")
    private String arrivalDateTime;

    @Column(name = "duration")
    private Long duration;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "segment_leg",
            joinColumns = @JoinColumn(name = "id_segment", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_leg", referencedColumnName = "id"))
    private List<Leg> legs = new ArrayList<>();
}

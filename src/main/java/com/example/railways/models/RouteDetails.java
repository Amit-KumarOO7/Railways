package com.example.railways.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString()
@Table(name = "route")
public class RouteDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter
    @Setter
    int rId;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private @Getter
    @Setter
    PlaceDetails fromId;
    @ManyToOne
    @JoinColumn(name = "to_id")
    private @Getter
    @Setter
    PlaceDetails toId;

    private @Getter
    @Setter
    String trainName;

    private @Getter
    @Setter
    LocalTime time;
}

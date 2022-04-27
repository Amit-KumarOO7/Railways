package com.example.railways.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
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
}

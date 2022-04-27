package com.example.railways.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "place")
public class PlaceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter
    @Setter
    int pId;

    public PlaceDetails(int pId) {
        this.pId = pId;
    }

    @Column
    private @Getter
    @Setter
    String pName;
}

package com.example.railways.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int trainNumber;

    @Column
    private @Getter @Setter String source;

    @Column
    private @Getter @Setter String destination;

    @Column
    private @Getter @Setter Date arrivalTime;

    @Column
    private @Getter @Setter Date departureTime;


}

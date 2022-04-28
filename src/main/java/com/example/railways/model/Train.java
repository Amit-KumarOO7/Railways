package com.example.railways.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "train")
public class Train {

    @Id
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

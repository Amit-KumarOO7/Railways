package com.example.railways.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "train")
public class Train {

    @Id
    private @Getter
    @Setter
    int trainNumber;

    @Column
    private @Getter
    @Setter
    String source;

    @Column
    private @Getter
    @Setter
    String destination;

    @Column
    private @Getter
    @Setter
    Date arrivalTime;

    @Column
    private @Getter
    @Setter
    Date departureTime;


}

package com.example.railways.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class TicketDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int tbId;

    @Column
    private @Getter @Setter int uId;

    @Column
    private @Getter @Setter String tbSource;

    @Column
    private @Getter @Setter String tbDestination;

    @Column
    private @Getter @Setter int tbStatus;
}

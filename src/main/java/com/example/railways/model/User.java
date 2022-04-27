package com.example.railways.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int uId;

    @Column
    private @Getter @Setter String uName;

    @Column
    private @Getter @Setter String uEmailId;

    @Column
    private @Getter @Setter String uAddress;

    @Column
    private @Getter @Setter String uDob;

    @Column
    private @Getter @Setter int age;

    @Column
    private @Getter @Setter String uAadhaar;

}

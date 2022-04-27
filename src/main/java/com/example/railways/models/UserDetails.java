package com.example.railways.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter
    @Setter
    int uId;

    @Column
    private @Getter
    @Setter
    String uName;

    @Column
    private @Getter
    @Setter
    String uEmailId;

    @Column
    private @Getter
    @Setter
    String uAddress;

    @Column
    private @Getter
    @Setter
    String uDob;

    @Column
    private @Getter
    @Setter
    int uAge;

    @Column
    private @Getter
    @Setter
    String uPassword;

    @Column
    private @Getter
    @Setter
    String uAadhaar;
}

package com.example.railways.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class UserFoundResponse {

    private @Getter @Setter Date date;

    private @Getter @Setter String message;

    private @Getter @Setter String status;
}

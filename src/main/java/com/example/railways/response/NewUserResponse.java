package com.example.railways.response;

import com.example.railways.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class NewUserResponse {

    private @Getter @Setter Date date;

    private @Getter @Setter String message;

    private @Getter @Setter String status;

    private @Getter @Setter User user;
}
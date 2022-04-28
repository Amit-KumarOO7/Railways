package com.example.railways.response;

import lombok.Getter;

import java.util.Date;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class TicketDeleteResponse {
	
	private @Getter @Setter Date date;

    private @Getter @Setter String message;

    private @Getter @Setter String status;

}

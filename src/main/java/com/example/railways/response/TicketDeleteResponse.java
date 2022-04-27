package com.example.railways.response;

import lombok.Getter;

import java.util.Date;

import com.example.railways.model.TicketDetails;

import lombok.*;

public class TicketDeleteResponse {
	
	

    public TicketDeleteResponse(Date date2, String string, String string2) {
	}
	private @Getter
    @Setter
    Date date;

    private @Getter
    @Setter
    String message;

    private @Getter
    @Setter
    String status;

}

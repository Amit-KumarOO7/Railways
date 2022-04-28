package com.example.railways.response;


import java.util.Date;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class TicketDeleteResponse {
	
	public TicketDeleteResponse(Date date2, String message, String status) {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    private String message;

    private String status;

}

package com.example.railways.controler;

import java.util.ArrayList;
import java.util.Date;

import com.example.railways.model.TicketDetails;
import com.example.railways.response.ErrorResponse;
import com.example.railways.response.TicketDeleteResponse;
import com.example.railways.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteTicketController {
    @Autowired
    TicketService ticketService;

	@DeleteMapping("/deleteTicket") 
	public ResponseEntity<Object> deleteTicket(@RequestBody TicketDetails ticketDetails){
        ArrayList<TicketDetails> ticketExists = ticketService.fetchTicket(ticketDetails.getUId());
        boolean ticketE=false;
        for(TicketDetails t : ticketExists){
            if(t.getTbId()==ticketDetails.getTbId()){
                ticketE=true;
            }
        }
        if (ticketE==false || ticketExists == null) {
            ErrorResponse response = new ErrorResponse(new Date(), "Ticket does not exist", "400");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        }
        ticketService.deleteTicket(ticketDetails.getUId(),ticketDetails.getTbId());
        TicketDeleteResponse response = new TicketDeleteResponse(new Date(), "Ticket deleted Successfully", "200");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
}

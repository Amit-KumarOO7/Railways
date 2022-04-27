package com.example.railways.service;

import com.example.railways.model.TicketDetails;

public interface TicketService {
    TicketDetails fetchTicket(TicketDetails ticketDetails);
    void deleteTicket(TicketDetails t);
}

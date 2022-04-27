package com.example.railways.service;

import com.example.railways.model.TicketDetails;

public interface TicketService {
    TicketDetails fetchTicket(int uId);
    void deleteTicket(int uId, int tbId);
}

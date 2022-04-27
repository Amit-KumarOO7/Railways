package com.example.railways.service;

import java.util.ArrayList;

import com.example.railways.model.TicketDetails;

public interface TicketService {
    ArrayList<TicketDetails> fetchTicket(int uId);
    void deleteTicket(int uId, int tbId);


}

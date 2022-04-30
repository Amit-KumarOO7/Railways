package com.example.railways.service;

import com.example.railways.models.TicketDetails;

import java.util.ArrayList;
import java.util.List;

public interface TicketService {
    ArrayList<TicketDetails> fetchTicket(int uId);

    void deleteTicket(int uId, int tbId);


}

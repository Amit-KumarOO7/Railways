package com.example.railways.serviceimpl;

import com.example.railways.model.TicketDetails;
import com.example.railways.repository.TicketRepository;
import com.example.railways.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;

public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository ticketRepository;
    @Override
    public TicketDetails fetchTicket(int uId) {
        
    return ticketRepository.fetchTicketByuId(uId);
    }

    @Override
    public void deleteTicket(int uId, int tbId) {
        ticketRepository.deleteTicket(uId, tbId);
        
    }

    
}

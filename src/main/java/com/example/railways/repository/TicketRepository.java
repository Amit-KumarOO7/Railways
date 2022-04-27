package com.example.railways.repository;

import com.example.railways.model.TicketDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketDetails, Long> {
    @Query(value = "SELECT * FROM tickets t WHERE t.u_id=?1", nativeQuery = true)
    TicketDetails fetchTicketByuId(int uId);

    @Query(value = "delete FROM tickets t WHERE t.u_id=?1 and t.tb_id=?2", nativeQuery = true)
    TicketDetails deleteTicket(int uId, int tbId);

    

}

package com.Reservation.com.Service;

import com.Reservation.com.Dto.DetailsDto;
import com.Reservation.com.Entity.Train;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


public interface TicketService {

    public boolean confirm(int number);

    public Train cancel(int number);

    public Train displayDetails(DetailsDto pnr);

}

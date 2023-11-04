package com.Reservation.com.Controller;

import com.Reservation.com.Dto.DetailsDto;
import com.Reservation.com.Dto.TrainNoDto;
import com.Reservation.com.Entity.Train;
import com.Reservation.com.Service.TicketService;
import com.Reservation.com.Service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/dashboard")
public class DashboardController
{

    private TicketService ticketService ;
    @Autowired
    public DashboardController(TicketService ticketService) {
        super();
        this.ticketService = ticketService;
    }

//    @RequestMapping("/Reserveticket")
//    public ResponseEntity<HttpStatus> confirmBooking(@ModelAttribute TrainNoDto trainDto)
//    {
//        try
//        {
//            ticketService.confirm(trainDto.getTrainNo());
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }

    @PostMapping("/cancelticket")
    @ResponseBody
    public  Train cancelBooking(@RequestBody DetailsDto detailsDto)
    {
        try
        {
            if(detailsDto!= null)
            {
                Train t =ticketService.cancel(detailsDto.getPnr());
                return t;
            }
            System.out.println("hello7");
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

//    @RequestMapping("/displayDetails")
//    public Train displayDetails(@RequestBody DetailsDto detailsDto)
//    {
//        Train t = null;
//        try
//        {
//             t = ticketService.displayDetails(detailsDto);
//            return t;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//
//        }
//        return null;
//    }

}

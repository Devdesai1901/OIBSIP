package com.Reservation.com.Service;

import com.Reservation.com.Dao.TrainRepo;
import com.Reservation.com.Dto.DetailsDto;
import com.Reservation.com.Entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{


    private TrainRepo trainRepo;

   @Autowired
    public TicketServiceImpl(TrainRepo trainRepo) {
        this.trainRepo = trainRepo;
    }

    Train train;



    @Override
    public boolean confirm(int number) {
        train = trainRepo.findByTrainNO(number);
        int num = train.getTotalBooking();
        num++;
        train.setTotalBooking(num);
        return true;
    }

    @Override
    public Train cancel(int number) {
       train = trainRepo.findByPnr(number);
//        int num = train.getTotalBooking();
//        num--;
//        train.setTotalBooking(num);
        return train;

    }

    @Override
    public Train displayDetails(DetailsDto detail) {
        Train t = new Train();
        if(detail != null)
        {
             t = trainRepo.findByPnr(detail.getPnr());
             return t;
        }
        return t;
    }
}

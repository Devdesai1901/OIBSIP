package com.Reservation.com.Dao;

import com.Reservation.com.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Train,Integer>
{
     Train findByPnr(int pnr);

     Train findByTrainNO(int trainNO);
}

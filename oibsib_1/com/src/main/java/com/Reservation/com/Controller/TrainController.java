package com.Reservation.com.Controller;

import com.Reservation.com.Dao.TrainRepo;
import com.Reservation.com.Entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/trainName")
public class TrainController {

    @Autowired
    TrainRepo trainRepo;

    @GetMapping("/num/{trainNo}")
    @ResponseBody
    public Train getTrainNameByTrainNo(@PathVariable("trainNo") String trainNum)
    {
        Train trainOptional;
        trainOptional = trainRepo.findByTrainNO(Integer.parseInt(trainNum));
        return trainOptional;
    }




}

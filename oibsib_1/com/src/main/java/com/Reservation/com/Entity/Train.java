package com.Reservation.com.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Time;

@Entity
public class Train  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int pnr;
    private int trainNO;

    private String trainName;
    private int totalBooking;
    private String dest;
    private String arrv;




    public int getTrainNO() {
        return trainNO;
    }

    public void setTrainNO(int trainNO) {
        this.trainNO = trainNO;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTotalBooking() {
        return totalBooking;
    }

    public void setTotalBooking(int totalBooking) {
        this.totalBooking = totalBooking;
    }


    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getArrv() {
        return arrv;
    }

    public void setArrv(String arrv) {
        this.arrv = arrv;
    }


    public int getPnr() {
        return pnr;
    }

    public void setPnr(int pnr) {
        this.pnr = pnr;
    }
}



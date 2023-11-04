package com.Reservation.com.Service;

import com.Reservation.com.Dto.SignDto;
import com.Reservation.com.Dto.SignUPDto;
import org.springframework.stereotype.Service;


public interface UserService {
    public boolean save(SignUPDto signUPDto);
    public boolean login(SignDto signDto);
}

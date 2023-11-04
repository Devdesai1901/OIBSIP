package com.Reservation.com.Controller;

import com.Reservation.com.Dto.SignDto;
import com.Reservation.com.Dto.SignUPDto;
import com.Reservation.com.Service.UserService;
import com.Reservation.com.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/reservation")
public class SignUpController {


     private UserService userService;
    @Autowired
    public SignUpController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> registerUserAccount(@RequestBody SignUPDto signUPDto)
    {
        boolean flag;
        try
        {
           flag=  userService.save(signUPDto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(flag == true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/signin")
    public ResponseEntity<HttpStatus> Authenticate(@RequestBody SignDto signDto)
    {
        boolean flag;
        try{
            flag = userService.login(signDto);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (flag == true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}

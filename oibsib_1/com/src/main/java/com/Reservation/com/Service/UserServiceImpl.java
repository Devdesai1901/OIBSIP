package com.Reservation.com.Service;

import com.Reservation.com.Dao.UserRepo;
import com.Reservation.com.Dto.SignDto;
import com.Reservation.com.Dto.SignUPDto;
import com.Reservation.com.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{



    private UserRepo userRepo;
@Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    @Override
    public boolean save(SignUPDto signUPDto) {
       if(signUPDto != null)
       {
           User user = new User();
           user.setUserName(signUPDto.getUsername());
           if(signUPDto.getEmail() != null && signUPDto.getPassword() != null)
           {
               System.out.println(signUPDto.getEmail());
               user.setPassword(signUPDto.getPassword());
               user.setEmail(signUPDto.getEmail());
               user.setPhoneNo(signUPDto.getMobileNo());
               userRepo.save(user);
           }
           else
           {
               return false;
           }


           return true;
       }
        return false;
    }

    @Override
    public boolean login(SignDto signDto) {
        if(signDto != null)
        {
            if(signDto.getEmail() != null && signDto.getPassword() != null)
            {
                User user = new User();
                try {
                     user = userRepo.findByEmail(signDto.getEmail());
                     System.out.println(user.getUserName());
                     String userEmail = user.getEmail();
                     String userPassword= (user.getPassword());
                     String inputEmail= (signDto.getEmail());
                     String inputPassword = (signDto.getPassword());

                     if (inputEmail.equals(userEmail) && inputPassword.equals(userPassword))
                     {
                         System.out.println("hello1");
                         return true;
                     }
                     else
                     {
                         System.out.println("hello2");
                         return false;
                     }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
            System.out.println("hello3");
            return false;
        }
        System.out.println("hello4");
        return false;
    }
}

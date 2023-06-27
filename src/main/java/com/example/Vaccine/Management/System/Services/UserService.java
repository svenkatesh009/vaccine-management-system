package com.example.Vaccine.Management.System.Services;
import com.example.Vaccine.Management.System.Dtos.UpdateEmailDto;
import com.example.Vaccine.Management.System.Gender.Gender;
import com.example.Vaccine.Management.System.Models.Dose;
import com.example.Vaccine.Management.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Vaccine.Management.System.Models.User;
import java.util.Date;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){

        user.setGender(Gender.MALE);

        System.out.println("The user is "+user);
        user = userRepository.save(user);
        return user;
    }

    public Date getVaccDate(Integer userId){

        User user = userRepository.findById(userId).get();

        Dose dose = user.getDose();

        return dose.getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto){

        int userId = updateEmailDto.getUserId();

        User user = userRepository.findById(userId).get();

        //Modify the entity with new parameters
        user.setEmailId(updateEmailDto.getNewEmailId());
        userRepository.save(user);
        return "Old Email has been modified with new one "+updateEmailDto.getNewEmailId();
    }

    public User getUserByEmail(String email){
        User user = userRepository.findByEmailId(email);
        return user;
    }


}
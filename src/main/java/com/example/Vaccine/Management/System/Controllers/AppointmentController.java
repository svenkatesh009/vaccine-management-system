package com.example.Vaccine.Management.System.Controllers;
import com.example.Vaccine.Management.System.Dtos.AppointmentReqDto;
import com.example.Vaccine.Management.System.Models.Doctor;
import com.example.Vaccine.Management.System.Services.AppointmentService;
import com.example.Vaccine.Management.System.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto){

        try {
            String result = appointmentService.bookAppointment(appointmentReqDto);
            return result;
        } catch (Exception e){
            return e.getMessage();
        }
    }

   @GetMapping("DoctorsWith10Appointment")
    public List<Doctor> doctorsWith10(){
        return appointmentService.doctorsWith10();
   }
}

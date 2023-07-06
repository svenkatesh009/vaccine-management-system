package com.example.Vaccine.Management.System.Controllers;

import com.example.Vaccine.Management.System.Dtos.AssociateDocDto;
import com.example.Vaccine.Management.System.Exceptions.DoctorNotFound;
import com.example.Vaccine.Management.System.Models.Doctor;
import com.example.Vaccine.Management.System.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){

        try {
            String response = doctorService.addDoctor(doctor);
            return response;
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @PostMapping("/associateWithCenter")
    public ResponseEntity<String> associateDoctor(@RequestBody AssociateDocDto associateDocDto){

        try{
            String result = doctorService.associateDoctor(associateDocDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/doctorRatio")
    public String doctorRatio(){
        return doctorService.getDoctorRatio();
    }

    @GetMapping("/getDetailsByEmail")
    public ResponseEntity<Doctor> doctorByEmail(String email){
        try{
            Doctor doctor=doctorService.getDoctorByEmail(email);
            return new ResponseEntity<>(doctor,HttpStatus.OK);
        } catch (DoctorNotFound e) {
            return new ResponseEntity<>(new Doctor(),HttpStatus.NOT_FOUND);
        }

    }

   @GetMapping("/doctorAbove40")
    public List<String> getDoctorAbove40(){
        return doctorService.getDoctorAbove40();
   }



}

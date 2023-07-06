package com.example.Vaccine.Management.System.Controllers;

import com.example.Vaccine.Management.System.Exceptions.CenterNotFound;
import com.example.Vaccine.Management.System.Exceptions.VaccinationAddressNotFound;
import com.example.Vaccine.Management.System.Models.Doctor;
import com.example.Vaccine.Management.System.Models.VaccinationCenter;
import com.example.Vaccine.Management.System.Services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationController {

    @Autowired
    public VaccinationService vaccinationService;

    @PostMapping("/add")
    public ResponseEntity<String> addCenter(@RequestBody VaccinationCenter vaccinationCenter){

        try {
            String result = vaccinationService.addVaccinationCenter(vaccinationCenter);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (VaccinationAddressNotFound e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getDoctors")
    public ResponseEntity<List<Doctor>> getDoctorList(@RequestParam Integer centerId){
        try{
           List<Doctor> doctorList=vaccinationService.getDoctorList(centerId);
            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        }
        catch (CenterNotFound e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }
    }



}

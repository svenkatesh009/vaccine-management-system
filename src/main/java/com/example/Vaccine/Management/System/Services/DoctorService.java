package com.example.Vaccine.Management.System.Services;

import com.example.Vaccine.Management.System.Dtos.AssociateDocDto;
import com.example.Vaccine.Management.System.Exceptions.CenterNotFound;
import com.example.Vaccine.Management.System.Exceptions.DoctorAlreadyExistsException;
import com.example.Vaccine.Management.System.Exceptions.DoctorNotFound;
import com.example.Vaccine.Management.System.Exceptions.EmailIdEmptyException;
import com.example.Vaccine.Management.System.Models.Doctor;
import com.example.Vaccine.Management.System.Models.VaccinationCenter;
import com.example.Vaccine.Management.System.Repository.DoctorRepository;
import com.example.Vaccine.Management.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private VaccinationCenterRepository centerRepository;

    public String addDoctor(Doctor doctor)throws EmailIdEmptyException, DoctorAlreadyExistsException {

        //Validations part is over :
        if(doctor.getEmailId()==null){
            throw new EmailIdEmptyException("Email id is mandatory");
        }

        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null){
            throw new DoctorAlreadyExistsException("Doctor with this emailId already exits.");
        }

        doctorRepository.save(doctor);

        return "Doctor has been added to the database";
    }

    public String associateDoctor(AssociateDocDto associateDocDto)throws DoctorNotFound, CenterNotFound {

        Integer docId = associateDocDto.getDocId();

        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);

        if(!doctorOptional.isPresent()){
            throw new DoctorNotFound("Doctor id is wrong");
        }

        Integer centerId = associateDocDto.getCenterId();

        Optional<VaccinationCenter> optionalCenter = centerRepository.findById(centerId);

        if(!optionalCenter.isPresent()){
            throw new CenterNotFound("Center Id entered is incorrect");
        }

        Doctor doctor = doctorOptional.get();




        VaccinationCenter vaccinationCenter = optionalCenter.get();





        doctor.setVaccinationCenter(vaccinationCenter); //Setting the foreign


        //Set the bidirectional map
        //Adding this doctor the list of doctors of that vaccination Center
        vaccinationCenter.getDoctorList().add(doctor);

        centerRepository.save(vaccinationCenter);

        return "Doctor has been associated to center";

    }

    public String getDoctorRatio() {
        int maleCount=doctorRepository.maleDoctorCount();
        int femaleCount=doctorRepository.femaleDoctorCount();
        return "The ratio between male and female dotor is :   "+maleCount/femaleCount;
    }

    public Doctor getDoctorByEmail(String email) throws DoctorNotFound {
        Doctor doctor=doctorRepository.findByEmailId(email);
        if(doctorRepository.findByEmailId(email)==null) throw new DoctorNotFound("Doctor email is invalid");
        return doctor;
    }

    public List<String> getDoctorAbove40() {
        return doctorRepository.getDoctorAbove40();
    }


}
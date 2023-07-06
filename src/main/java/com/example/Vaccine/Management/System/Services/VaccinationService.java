package com.example.Vaccine.Management.System.Services;
import com.example.Vaccine.Management.System.Exceptions.CenterNotFound;
import com.example.Vaccine.Management.System.Exceptions.VaccinationAddressNotFound;
import com.example.Vaccine.Management.System.Models.Doctor;
import com.example.Vaccine.Management.System.Models.VaccinationCenter;
import com.example.Vaccine.Management.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addVaccinationCenter(VaccinationCenter vaccinationCenter)throws VaccinationAddressNotFound {

        if(vaccinationCenter.getAddress()==null){
            throw new VaccinationAddressNotFound("Vaccination Address is Empty");
        }

        vaccinationCenterRepository.save(vaccinationCenter);

        return "Vaccination center added at a location "+vaccinationCenter.getAddress();

    }

    public List<Doctor> getDoctorList(Integer centerId) throws CenterNotFound {
        if(!vaccinationCenterRepository.existsById(centerId)){
            throw new CenterNotFound("Center Id is invalid");
        }
        return vaccinationCenterRepository.findById(centerId).get().getDoctorList();
    }

}

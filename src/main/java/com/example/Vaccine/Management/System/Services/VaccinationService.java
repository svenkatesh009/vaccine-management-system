package com.example.Vaccine.Management.System.Services;
import com.example.Vaccine.Management.System.Exceptions.VaccinationAddressNotFound;
import com.example.Vaccine.Management.System.Models.VaccinationCenter;
import com.example.Vaccine.Management.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

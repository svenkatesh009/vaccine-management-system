package com.example.Vaccine.Management.System.Repository;

import com.example.Vaccine.Management.System.Models.Doctor;
import com.example.Vaccine.Management.System.Models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

}

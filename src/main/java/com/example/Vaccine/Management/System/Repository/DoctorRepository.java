package com.example.Vaccine.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Vaccine.Management.System.Models.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    public Doctor findByEmailId(String emailId);

}
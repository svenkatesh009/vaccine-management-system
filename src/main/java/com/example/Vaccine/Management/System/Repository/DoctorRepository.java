package com.example.Vaccine.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Vaccine.Management.System.Models.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    Doctor findByEmailId(String emailId);

    @Query(value = "Select count(*) from doctors where gender = 'MALE'",nativeQuery = true)
    int maleDoctorCount();

    @Query(value = "Select count(*) from doctors where gender = 'FEMALE'",nativeQuery = true)
    int femaleDoctorCount();

    @Query(value = "Select name from doctors where gender = 'MALE' and age>= 40",nativeQuery = true)
    List<String> getDoctorAbove40();


}
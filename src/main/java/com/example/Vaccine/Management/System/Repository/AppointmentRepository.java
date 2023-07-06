package com.example.Vaccine.Management.System.Repository;

import com.example.Vaccine.Management.System.Models.Appointment;
import com.example.Vaccine.Management.System.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Query(value = "Select doctor_doc_id as d from appointments  group by d having count(d) >= 10",nativeQuery = true)
    List<Integer> getMore10App();
}
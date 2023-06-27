package com.example.Vaccine.Management.System.Repository;

import com.example.Vaccine.Management.System.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}

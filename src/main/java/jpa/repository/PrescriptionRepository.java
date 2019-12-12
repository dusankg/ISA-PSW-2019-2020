package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.modeli.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}

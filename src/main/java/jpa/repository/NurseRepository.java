package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.modeli.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Long> {

	
}

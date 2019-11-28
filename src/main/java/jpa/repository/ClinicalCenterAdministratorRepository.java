package jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import jpa.modeli.ClinicalAdministrator;
import jpa.modeli.ClinicalCenterAdministrator;

public interface ClinicalCenterAdministratorRepository extends JpaRepository<ClinicalCenterAdministrator, Long> {
	
	ClinicalCenterAdministrator findOneByName(String name);
	Page<ClinicalCenterAdministrator> findAll(Pageable pageable);
	ClinicalCenterAdministrator findOneBySurname(String surname);
}

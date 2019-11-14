package repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modeli.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	Patient findOneByName(String name);

	
	Page<Patient> findAll(Pageable pageable);

	
	List<Patient> findAllBySurname(String surname);

	
	List<Patient> findByNameAndSurnameAllIgnoringCase(String name, String surname);

	
	@Query("select p from Patient p where p.surname = ?1")
	List<Patient> pronadjiPacijentePoPrezimenu(String prezime);
	
}
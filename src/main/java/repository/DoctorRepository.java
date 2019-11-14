package repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import modeli.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	Doctor findOneById(Long id);
	
	Doctor findOneByName(String name);
	
	Doctor findOneBySurname(String surname);
	
	Doctor findOneByEmail(String email);
	
	List<Doctor> findAll(Pageable pageable);
	
	List<Doctor> findAllByName(String name);
	
	List<Doctor> findAllBySurname(String surname);
	
	List<Doctor> findByNameAndSurnameAllIgnoringCase(String name, String surname);
}

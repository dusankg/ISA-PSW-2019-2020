package repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modeli.Diagnosis;
import modeli.Patient;
import modeli.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>{
	Diagnosis findOneByName(String name);

	
	Page<Diagnosis> findAll(Pageable pageable);

	
	List<Diagnosis> findAllByName(String name);

	
	List<Diagnosis> findByNameAllIgnoringCase(String name);

	
	@Query("select d from Diagnosis d where d.name = ?1")
	List<Diagnosis> pronadjiDijagnozePoImenu(String name);
	
}

package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import modeli.Doctor;
import repository.DoctorRepository;

public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor findOne(Long id) {
		return doctorRepository.findById(id).orElseGet(null);
	}

	public Doctor findOneByName(String name) {
		return doctorRepository.findOneByName(name);
	}
	
	public Doctor findOneBySurname(String surname) {
		return doctorRepository.findOneBySurname(surname);
	}
	
	// Pageable check if it needs to be added
	
	public Doctor findOneByEmail(String email) {
		return doctorRepository.findOneByEmail(email);
	}
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	public List<Doctor> findByName(String name) {
		return doctorRepository.findAllByName(name);
	}
	
	public List<Doctor> findBySurname(String surname){
		return doctorRepository.findAllBySurname(surname);
	}
	
	public List<Doctor> findByNameAndSurname(String name, String surname) {
		return doctorRepository.findByNameAndSurnameAllIgnoringCase(name, surname);
	}
	
	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public void remove(Long id) {
		doctorRepository.deleteById(id);
	}
	
	
}

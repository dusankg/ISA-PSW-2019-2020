package jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpa.dto.DoctorDTO;
import jpa.modeli.Doctor;
import jpa.service.DoctorService;


import jpa.dto.DoctorDTO;
import jpa.modeli.Doctor;
import jpa.service.DoctorService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RequestMapping(value = "api/doctors")
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
		List<Doctor> doctors = doctorService.findAll();
		
		//convert doctors to DTOs
		List<DoctorDTO> doctorsDTO = new ArrayList<>();
		for (Doctor d : doctors) {
			doctorsDTO.add(new DoctorDTO(d));
		}
		
		return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
	}
	
	//Pageable check
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id) {

		Doctor doctor = doctorService.findOne(id);

		// doctor must exist
		if (doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<DoctorDTO> saveDoctor(@RequestBody DoctorDTO doctorDTO) {

		Doctor doctor = new Doctor();
		doctor.setId(222);
		doctor.setName(doctorDTO.getName());
		doctor.setSurname(doctorDTO.getSurname());
		doctor.setEmail(doctorDTO.getEmail());
		doctor.setPassword(doctorDTO.getPassword());
		doctor.setAdress(doctorDTO.getAdress());
		doctor.setCity(doctorDTO.getCity());
		doctor.setState(doctorDTO.getState());
		doctor.setPhone(doctorDTO.getPhone());
		
		doctor = doctorService.save(doctor);
		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<DoctorDTO> updateDoctor(@RequestBody DoctorDTO doctorDTO) {

		// a doctor must exist
		Doctor doctor = doctorService.findOne(doctorDTO.getId());

		if (doctor == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		doctor.setName(doctorDTO.getName());
		doctor.setSurname(doctorDTO.getSurname());
		doctor.setEmail(doctorDTO.getEmail());
		doctor.setPassword(doctorDTO.getPassword());
		doctor.setAdress(doctorDTO.getAdress());
		doctor.setCity(doctorDTO.getCity());
		doctor.setState(doctorDTO.getState());
		doctor.setPhone(doctorDTO.getPhone());

		doctor = doctorService.save(doctor);
		return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {

		Doctor doctor = doctorService.findOne(id);

		if (doctor != null) {
			doctorService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	
	

	

	
	
	

	
}
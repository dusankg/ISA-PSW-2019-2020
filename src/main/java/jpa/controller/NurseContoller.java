package jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.dto.DoctorDTO;
import jpa.dto.NurseDTO;
import jpa.modeli.Doctor;
import jpa.modeli.Nurse;
import jpa.service.NurseService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RequestMapping(value = "api/nurses")
public class NurseContoller {

	@Autowired
	private NurseService nurseService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<NurseDTO>> getAllDoctors(){
		List<Nurse> nurses = nurseService.findAll();
		
		
		List<NurseDTO> nursesDTO = new ArrayList<>();
		for (Nurse n : nurses) {
			nursesDTO.add(new NurseDTO(n));
		}
		
		return new ResponseEntity<>(nursesDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<NurseDTO> getDoctor(@PathVariable Long id) {

		Nurse nurse = nurseService.findOne(id);

		// doctor must exist
		if (nurse == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new NurseDTO(nurse), HttpStatus.OK);
	}
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<NurseDTO> saveNurse(@RequestBody NurseDTO nurseDTO) {

		Nurse nurse = new Nurse();
		nurse.setId(222l);
		nurse.setName(nurseDTO.getName());
		nurse.setSurname(nurseDTO.getSurname());
		nurse.setEmail(nurseDTO.getEmail());
		nurse.setPassword(nurseDTO.getPassword());
		nurse.setAdress(nurseDTO.getAdress());
		nurse.setCity(nurseDTO.getCity());
		nurse.setState(nurseDTO.getState());
		nurse.setPhone(nurseDTO.getPhone());
		
		nurse = nurseService.save(nurse);
		
		return new ResponseEntity<>(new NurseDTO(nurse), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteNurse(@PathVariable Long id) {

		Nurse nurse = nurseService.findOne(id);

		if (nurse != null) {
			nurseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}











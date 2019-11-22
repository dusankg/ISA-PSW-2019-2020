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

import jpa.dto.ClinicDTO;
import jpa.modeli.Clinic;
import jpa.service.ClinicService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RequestMapping(value = "api/clinics")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ClinicDTO>> getAllClinics() {

		List<Clinic> clinics = clinicService.findAll();

		// convert clinics to DTOs
		List<ClinicDTO> clinicDTO = new ArrayList<>();
		for (Clinic c : clinics) {
			clinicDTO.add(new ClinicDTO(c));
		}

		return new ResponseEntity<>(clinicDTO, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ClinicDTO>> getClinicsPage(Pageable page) {

		// page object holds data about pagination and sorting
		// the object is created based on the url parameters "page", "size" and "sort"
		Page<Clinic> clinics = clinicService.findAll(page);

		// convert clinics to DTOs
		List<ClinicDTO> clinicsDTO = new ArrayList<>();
		for (Clinic s : clinics) {
			clinicsDTO.add(new ClinicDTO(s));
		}

		return new ResponseEntity<>(clinicsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClinicDTO> getClinic(@PathVariable Long id) {

		Clinic clinic = clinicService.findOne(id);

		// studen must exist
		if (clinic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClinicDTO>(new ClinicDTO(clinic), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<ClinicDTO> saveClinic(@RequestBody ClinicDTO clinicDTO) {

		Clinic clinic = new Clinic();
		clinic.setId(222);
		clinic.setName(clinicDTO.getName());
		clinic.setAdress(clinicDTO.getAdress());
		clinic.setDescription(clinicDTO.getDescription());
		clinic.setGradeSum(clinicDTO.getGradeSum());
		clinic.setGradeNumber(clinicDTO.getGradeNumber());
		
		System.out.println("********* Prosledjeni naziv klinike: " + clinicDTO.getName()+ " ***************");

		clinic = clinicService.save(clinic);
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.CREATED);
	}
	
	
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<ClinicDTO> updateClinic(@RequestBody ClinicDTO clinicDTO) {

		// a clinic must exist
		Clinic clinic = clinicService.findOne(clinicDTO.getId());

		if (clinic == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		clinic.setName(clinicDTO.getName());
		clinic.setAdress(clinicDTO.getAdress());
		clinic.setDescription(clinicDTO.getDescription());
		clinic.setGradeSum(clinicDTO.getGradeSum());
		clinic.setGradeNumber(clinicDTO.getGradeNumber());

		clinic = clinicService.save(clinic);
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteclinic(@PathVariable Long id) {

		Clinic clinic = clinicService.findOne(id);

		if (clinic != null) {
			clinicService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value = "/findName")
	public ResponseEntity<ClinicDTO> getClinicByName(@RequestParam String name) {

		Clinic clinic = clinicService.findOneByName(name);
		if (clinic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/findAdress")
	public ResponseEntity<ClinicDTO> getClinicByAdress(@RequestParam String adress) {

		Clinic clinic = clinicService.findOneByName(adress);
		if (clinic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ClinicDTO(clinic), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

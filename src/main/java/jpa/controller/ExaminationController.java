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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.dto.ExaminationDTO;
import jpa.modeli.Examination;
import jpa.service.ExaminationService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "http://localhost:8080"})
@RequestMapping(value = "api/examinations")
public class ExaminationController {

	@Autowired
	private ExaminationService examinationService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<ExaminationDTO>> getAllExaminations(){
		List<Examination> examinations = examinationService.findAll();
		
		//convert examinations to DTOs
		List<ExaminationDTO> examinationsDTO = new ArrayList<>();
		for (Examination e : examinations) {
			examinationsDTO.add(new ExaminationDTO(e));
		}
		
		return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExaminationDTO> getExamination(@PathVariable Long id) {

		Examination examination = examinationService.findOne(id);

		// examination must exist
		if (examination == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<ExaminationDTO> saveExamination(@RequestBody ExaminationDTO examinationDTO) {

		Examination examination = new Examination();
		examination.setId(null);
		examination.setDate(examinationDTO.getDate());
		examination.setDuration(examinationDTO.getDuration());
		examination.setPrice(examinationDTO.getPrice());

		examination = examinationService.save(examination);
		return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<ExaminationDTO> updateExamination(@RequestBody ExaminationDTO examinationDTO) {

		// an examination must exist
		Examination examination = examinationService.findOne(examinationDTO.getId());

		if (examination == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		examination.setDate(examinationDTO.getDate());
		examination.setDuration(examinationDTO.getDuration());
		examination.setPrice(examinationDTO.getPrice());

		examination = examinationService.save(examination);
		return new ResponseEntity<>(new ExaminationDTO(examination), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteExamination(@PathVariable Long id) {

		Examination examination = examinationService.findOne(id);

		if (examination != null) {
			examinationService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

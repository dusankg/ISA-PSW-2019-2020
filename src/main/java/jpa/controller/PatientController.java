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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import jpa.dto.PatientDTO;
import jpa.modeli.Patient;
import jpa.service.PatientService;


import jpa.dto.PatientDTO;
import jpa.modeli.Patient;
import jpa.service.PatientService;


	@RestController
	@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
	@RequestMapping(value = "api/patients")
public class PatientController {

		@Autowired
		private PatientService patientService;

		@GetMapping(value = "/all")
		public ResponseEntity<List<PatientDTO>> getAllPatients() {

			List<Patient> patients = patientService.findAll();

			// convert Patients to DTOs
			List<PatientDTO> patientsDTO = new ArrayList<>();
			for (Patient p : patients) {
				patientsDTO.add(new PatientDTO(p));
			}

			return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
		}

		@GetMapping
		public ResponseEntity<List<PatientDTO>> getPatientsPage(Pageable page) {

			
			Page<Patient> patients = patientService.findAll(page);

		
			List<PatientDTO> patientsDTO = new ArrayList<>();
			for (Patient p : patients) {
				patientsDTO.add(new PatientDTO(p));
			}

			return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
		}

		@GetMapping(value = "/{id}")
		public ResponseEntity<PatientDTO> getPatient(@PathVariable Long id) {

			Patient Patient = patientService.findOne(id);

			
			if (Patient == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(new PatientDTO(Patient), HttpStatus.OK);
		}

		@PostMapping(consumes = "application/json")
		public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO PatientDTO) {

			Patient Patient = new Patient();
			Patient.setName(PatientDTO.getName());
			Patient.setSurname(PatientDTO.getSurname());
			Patient.setEmail(PatientDTO.getEmail());
			Patient.setPassword(PatientDTO.getPassword());
			Patient.setAdress(PatientDTO.getAdress());
			Patient.setCity(PatientDTO.getCity());
			Patient.setState(PatientDTO.getState());
			Patient.setPhone(PatientDTO.getPhone());
			Patient.setLbo(PatientDTO.getLbo());

			Patient = patientService.save(Patient);
			return new ResponseEntity<>(new PatientDTO(Patient), HttpStatus.CREATED);
		}

		@PutMapping(consumes = "application/json")
		public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO PatientDTO) {

			// a Patient must exist
			Patient Patient = patientService.findOne(PatientDTO.getId());

			if (Patient == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			Patient.setName(PatientDTO.getName());
			Patient.setSurname(PatientDTO.getSurname());
			Patient.setEmail(PatientDTO.getEmail());
			Patient.setPassword(PatientDTO.getPassword());
			Patient.setAdress(PatientDTO.getAdress());
			Patient.setCity(PatientDTO.getCity());
			Patient.setState(PatientDTO.getState());
			Patient.setPhone(PatientDTO.getPhone());
			Patient.setLbo(PatientDTO.getLbo());

			Patient = patientService.save(Patient);
			return new ResponseEntity<>(new PatientDTO(Patient), HttpStatus.OK);
		}

		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> deletePatient(@PathVariable Long id) {

			Patient Patient = patientService.findOne(id);

			if (Patient != null) {
				patientService.remove(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		@GetMapping(value = "/findName")
		public ResponseEntity<PatientDTO> getPatientByIndex(@RequestParam String index) {

			Patient Patient = patientService.findByIndex(index);
			if (Patient == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(new PatientDTO(Patient), HttpStatus.OK);
		}

		@GetMapping(value = "/findLastName")
		public ResponseEntity<List<PatientDTO>> getPatientsByLastName(@RequestParam String lastName) {

			List<Patient> Patients = patientService.findByLastName(lastName);

			// convert Patients to DTOs
			List<PatientDTO> PatientsDTO = new ArrayList<>();
			for (Patient s : Patients) {
				PatientsDTO.add(new PatientDTO(s));
			}
			return new ResponseEntity<>(PatientsDTO, HttpStatus.OK);
		}

		@GetMapping(value = "/prezime")
		public ResponseEntity<List<PatientDTO>> pronadjiPatientePoPrezimenu(@RequestParam String lastName) {

			List<Patient> Patients = patientService.pronadjiPoPrezimenu(lastName);

			// convert Patients to DTOs
			List<PatientDTO> PatientsDTO = new ArrayList<>();
			for (Patient s : Patients) {
				PatientsDTO.add(new PatientDTO(s));
			}
			return new ResponseEntity<>(PatientsDTO, HttpStatus.OK);
		}

		@GetMapping(value = "/findFirstLast")
		public ResponseEntity<List<PatientDTO>> getPatientsByFirstNameAndLastName(@RequestParam String firstName,
				@RequestPart String lastName) {

			List<Patient> Patients = patientService.findByFirstNameAndLastName(firstName, lastName);

			// convert Patients to DTOs
			List<PatientDTO> PatientsDTO = new ArrayList<>();
			for (Patient s : Patients) {
				PatientsDTO.add(new PatientDTO(s));
			}
			return new ResponseEntity<>(PatientsDTO, HttpStatus.OK);
		}

	/*	@GetMapping(value = "/{PatientId}/Prescriptions")
		public ResponseEntity<List<PrescriptionDTO>> getPatientExams(@PathVariable Long PatientId) {
			Patient Patient = patientService.findOne(PatientId);
			Set<Prescription> prescriptions = Patient.getPrescription();
			List<PrescriptionDTO> examsDTO = new ArrayList<>();
			for (Prescription p : Prescription) {
				PrescriptionDTO prescriptionDTO = new ExamDTO();
				prescriptionDTO.setId(e.getId());
				prescriptionDTO.setGrade(e.getGrade());
				prescriptionDTO.setDate(e.getDate());
				prescriptionDTO.setCourse(new CourseDTO(e.getCourse()));
				prescriptionDTO.setPatient(new PatientDTO(e.getPatient()));

				examsDTO.add(prescriptionDTO);
			}
			return new ResponseEntity<>(examsDTO, HttpStatus.OK);
		}*/
		// Ovo dodati kada se za sve MODELE URADEEEEE
}


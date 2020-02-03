
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

import jpa.dto.MedicalRoomDTO;
import jpa.modeli.Clinic;
import jpa.modeli.MedicalRoom;
import jpa.service.ClinicService;
import jpa.service.MedicalRoomService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RequestMapping(value = "api/medicalrooms")
public class MedicalRoomController {

	@Autowired
	private MedicalRoomService medicalRoomService;
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<MedicalRoomDTO>>getAllMedicalRooms(){
		List<MedicalRoom> medicalRooms = medicalRoomService.findAll();
		
		//convert medical rooms to DTO
		List<MedicalRoomDTO> medicalRoomsDTO = new ArrayList<>();
			for (MedicalRoom mr : medicalRooms) {
				medicalRoomsDTO.add(new MedicalRoomDTO(mr));
			}
		return new ResponseEntity<>(medicalRoomsDTO, HttpStatus.OK);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicalRoomDTO> getMedicalRoom(@PathVariable Long id) {

		MedicalRoom medicalRoom = medicalRoomService.findOne(id);

		// room must exist
		if (medicalRoom == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new MedicalRoomDTO(medicalRoom), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<MedicalRoomDTO> saveMedicalRoom(@RequestBody MedicalRoomDTO medicalRoomDTO) {

		// new room must have clinic defined
		if(medicalRoomDTO.getClinic() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Clinic clinic = clinicService.findOne(medicalRoomDTO.getClinic().getId());
		
		if(clinic == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		MedicalRoom medicalRoom = new MedicalRoom();
		medicalRoom.setId(0);
		medicalRoom.setOperational(medicalRoomDTO.getOperational());
		medicalRoom.setReserved(medicalRoomDTO.getReserved());
		medicalRoom.setRoomCodeName(medicalRoomDTO.getRoomCodeName());
		medicalRoom.setRoomNumber(medicalRoomDTO.getRoomNumber());
		medicalRoom.setDate(medicalRoomDTO.getDate());
		medicalRoom.setClinic(clinic);
		
		medicalRoom = medicalRoomService.save(medicalRoom);
		return new ResponseEntity<>(new MedicalRoomDTO(medicalRoom), HttpStatus.CREATED);
	}

	@PutMapping(consumes = "application/json")
	public ResponseEntity<MedicalRoomDTO> updateMedicalRoom(@RequestBody MedicalRoomDTO medicalRoomDTO) {

		// a room must exist
		MedicalRoom medicalRoom = medicalRoomService.findOne(medicalRoomDTO.getId());

		if (medicalRoom == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		medicalRoom.setOperational(medicalRoomDTO.getOperational());
		medicalRoom.setReserved(medicalRoomDTO.getReserved());
		medicalRoom.setRoomCodeName(medicalRoomDTO.getRoomCodeName());
		medicalRoom.setRoomNumber(medicalRoomDTO.getRoomNumber());
		medicalRoom.setDate(medicalRoomDTO.getDate());
		
		medicalRoom = medicalRoomService.save(medicalRoom);
		return new ResponseEntity<>(new MedicalRoomDTO(medicalRoom), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteMedicalRoom(@PathVariable Long id) {

		MedicalRoom medicalRoom = medicalRoomService.findOne(id);

		if (medicalRoom != null) {
			if(!medicalRoom.getReserved()) 
				medicalRoomService.remove(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

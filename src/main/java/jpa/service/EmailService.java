package jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jpa.modeli.ClinicalCenterAdministrator;
import jpa.modeli.Patient;



@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment env;


	@Async
	public void sendNotificaitionAsync(Patient patient) throws MailException, InterruptedException {

		
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("isapswgrupa11@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Validacija pacijenta: " + patient.getName());
		mail.setText("Pozdrav " + patient.getName() + ",\n\nhvala što pratiš ISA. Ovde ces aktivirati nalog "+ "http://localhost:8082/api/patients/validate/" + patient.getId());
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendNotificaitionAsync(ClinicalCenterAdministrator admin) throws MailException, InterruptedException {


		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("isapswgrupa11@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Validacija administratora: " + admin.getName());
		mail.setText("Pozdrav " + admin.getName() + ",\n\n Klikom na link ces potvrditi svoju registraciju: " + "http://localhost:8080/ValidateClinicalCenterAdministrator/"+admin.getId());
		//mail.setText("http://localhost:8082/api/clinicalCenterAdministrators/validate/"+admin.getId());
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

	public void sendNotificaitionSync(Patient patient) throws MailException, InterruptedException {


		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(patient.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomocu asinhronog Spring taska");
		mail.setText("Pozdrav " + patient.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}

}
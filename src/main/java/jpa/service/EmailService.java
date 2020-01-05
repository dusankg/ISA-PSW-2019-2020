package jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jpa.modeli.ClinicalCenterAdministrator;
import jpa.modeli.Doctor;
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
		mail.setText("Pozdrav " + patient.getName() + ",\n\n Vas zahtev za registaciju je prihacen. Ovde ces aktivirati nalog "+ "http://localhost:8082/api/patients/validate/" + patient.getId());
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

	// send auto generated email with predefined message
	public void sendNotificaitionSync(Patient patient) throws MailException, InterruptedException {


		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("isapswgrupa11@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Primer slanja emaila pomocu asinhronog Spring taska");
		mail.setText("Pozdrav " + patient.getName() + ",\n\nhvala što pratiš ISA.");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	// send email with custom message
	public void sendNotificaitionSync(Patient patient, String message) throws MailException, InterruptedException {


		System.out.println("Slanje emaila. Tekst email-a: " + message);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("isapswgrupa11@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject(message);
		mail.setText("Pozdrav " + patient.getName() + ",\n\n." + message);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	public void sendNotificaitionReject(Patient patient, String message) throws MailException, InterruptedException {


		System.out.println("Slanje emaila. Tekst email-a: " + message);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("isapswgrupa11@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Vas zahtev za registraciju je odbijen");
		mail.setText("Pozdrav " + patient.getName() + ",\n Vas zahtev za registraciju je odbijen.\nRazlog odbijanja:\n" + message);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	//E-mails for absence requests
	@Async
	public void sendNotificationAccept(Doctor doctor) throws MailException, InterruptedException{
		
		System.out.println("Slanje emaila... ");
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("isapswgrupa11@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Vaš zahtev za godišnji odmor je prihvaćen");
		mail.setText("Pozdrav " + doctor.getName() + ",\nVaš zahtev za godišnji odmor je prihvaćen.");
		javaMailSender.send(mail);
		
		System.out.println("Email je poslat!");
	}
	
	@Async
	public void sendNotificationDecline(Doctor doctor, String message) throws MailException, InterruptedException{
		
		System.out.println("Slanje emaila...");
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("isapswgrupa11@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Vaš zahtev za godišnji odmor je odbijen.");
		mail.setText("Pozdrav " + doctor.getName() + ",\nVaš zahtev za godišnji odmor je odbijen.\nObrazloženje:\n" + message);
		javaMailSender.send(mail);
		
		System.out.println("Email je poslat!");
	}
	
	
	
	
	
	
	
	
	

}
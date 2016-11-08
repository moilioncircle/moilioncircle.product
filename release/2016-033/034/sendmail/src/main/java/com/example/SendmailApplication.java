package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class SendmailApplication implements CommandLineRunner{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${mail.user}")
	private String from;
	
	@Value("${mail.subject}")
	private String subject;
	
	@Value("${mail.templet}")
	private String templet;
	
	@Value("${mail.users}")
	private String users;
	
	public static void main(String[] args) {
		SpringApplication.run(SendmailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		


		String body = FileUtils.readFileToString(new File(templet),"UTF8");
		
		Reader in = new InputStreamReader(new FileInputStream(users),"UTF8");
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(in);
		for (CSVRecord record : records) {
		    String name = record.get("name");
		    String to = record.get("mail");
		    
			String sub = parse(subject,name);
			String text = parse(body,name);
			sendMail(to, sub, text);
			
			Thread.sleep(5000);
		}
	}

	private String parse(String templet,String value){
		return templet.replaceAll("\\{\\{name\\}\\}", value);
	}
	
	private void sendMail(String to, String subject, String text) throws MessagingException {
		MimeMessage msg =  javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text);
		javaMailSender.send(msg);
	}
}

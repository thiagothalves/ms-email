package com.microservice.msemail.service;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.microservice.msemail.core.Email;
import com.microservice.msemail.core.StatusEmail;
import com.microservice.msemail.dto.EmailDto;
import com.microservice.msemail.repository.EmailRepository;
import com.microservice.msemail.util.GenericService;

@Service
public class EmailService implements GenericService<Email, EmailDto, Long> {

	private static final Logger LOGGER = Logger.getLogger("EmailService");

	@Autowired
	EmailRepository emailRepository;

	@Autowired
	private JavaMailSender emailSender;

	public Email enviar(Email email) {
		email.setOriginadoEm(Instant.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getDe());
			message.setTo(email.getPara());
			message.setSubject(email.getAssunto());
			message.setText(email.getTexto());
			emailSender.send(message);
			email.setStatusEmail(StatusEmail.ENVIADO);
		} catch (Exception e) {
			email.setStatusEmail(StatusEmail.ERRO);
			LOGGER.log(Level.SEVERE, e.getMessage());
		} finally {
			emailRepository.save(email);
		}

		return email;
	}

	@Override
	public JpaRepository<Email, Long> getRepository() {
		return emailRepository;
	}

}

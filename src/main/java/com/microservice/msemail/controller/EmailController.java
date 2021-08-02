package com.microservice.msemail.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.msemail.core.Email;
import com.microservice.msemail.dto.EmailDto;
import com.microservice.msemail.service.EmailService;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

	@Autowired
	EmailService emailService;

	@PostMapping
	public ResponseEntity<EmailDto> enviar(@RequestBody @Valid EmailDto emailDto) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDto, email);
		return new ResponseEntity<>(new EmailDto(emailService.enviar(email)), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmailDto> findById(@PathVariable Long id) {
		EmailDto dto = emailService.findById(id);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<Page<EmailDto>> retornarEmails(
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<EmailDto> emails = emailService.findAll(pageable);
		if (emails.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(emails, HttpStatus.OK);
		}
	}

}

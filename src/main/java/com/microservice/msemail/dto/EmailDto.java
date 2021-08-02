package com.microservice.msemail.dto;

import java.time.Instant;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import com.microservice.msemail.core.Email;
import com.microservice.msemail.core.StatusEmail;

public class EmailDto {

	private Long id;
	@NotBlank
	private String proprietarioId;
	@NotBlank
	private String de;
	@NotBlank
	private String para;
	@NotBlank
	private String assunto;
	@NotBlank
	private String texto;
	private Instant originadoEm;
	private StatusEmail statusEmail;

	public EmailDto() {
		super();
	}

	public EmailDto(Email email) {
		BeanUtils.copyProperties(email, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProprietarioId() {
		return proprietarioId;
	}

	public void setProprietarioId(String proprietarioId) {
		this.proprietarioId = proprietarioId;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Instant getOriginadoEm() {
		return originadoEm;
	}

	public void setOriginadoEm(Instant originadoEm) {
		this.originadoEm = originadoEm;
	}

	public StatusEmail getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}

}

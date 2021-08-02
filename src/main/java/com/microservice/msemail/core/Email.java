package com.microservice.msemail.core;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.microservice.msemail.dto.EmailDto;
import com.microservice.msemail.util.Convertible;
import com.microservice.msemail.util.Entidade;

@Entity
@Table(name = "email")
public class Email extends Entidade implements Serializable, Convertible<EmailDto> {

	private static final long serialVersionUID = 1L;

	private String proprietarioId;
	private String de;
	private String para;
	private String assunto;
	@Column(columnDefinition = "TEXT")
	private String texto;
	private Instant originadoEm;
	private StatusEmail statusEmail;

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

	@Override
	public EmailDto convert() {
		return new EmailDto(this);
	}

}

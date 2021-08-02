package com.microservice.msemail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.msemail.core.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}

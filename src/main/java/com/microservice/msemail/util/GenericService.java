package com.microservice.msemail.util;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<T extends Convertible<D>, D, K> {

	JpaRepository<T, K> getRepository();

	default D findById(K id) {
		Optional<T> result = getRepository().findById(id);
		return result.isPresent() ? result.get().convert() : null;
	}

	default Page<D> findAll(Pageable pageable) {
		return getRepository().findAll(pageable).map(T::convert);
	}

}

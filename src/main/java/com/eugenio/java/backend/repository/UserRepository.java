package com.eugenio.java.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eugenio.java.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//
	User findByCpf(String cpf);
	
	List<User> queryByNomeLike(String nome);
	
}

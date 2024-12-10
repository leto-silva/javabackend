package com.eugenio.java.backend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eugenio.java.backend.dto.UserDTO;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class UserController {
	//
	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
		
	@PostConstruct
	public void initiateList() {
		//
		UserDTO userDTO = new UserDTO();
		userDTO.setNome("eduardo");
		userDTO.setCpf("123");
		userDTO.setEndereco("Rua A");
		userDTO.setEmail("eduardo@email.com");
		userDTO.setTelefone("1234-1234");
		userDTO.setDataCadastro(new Date());
		
		UserDTO userDTO1 = new UserDTO();
		userDTO1.setNome("leto");
		userDTO1.setCpf("1236");
		userDTO1.setEndereco("Rua A");
		userDTO1.setEmail("leto@email.com");
		userDTO1.setTelefone("1234-1234");
		userDTO1.setDataCadastro(new Date());
		
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setNome("vera");
		userDTO2.setCpf("1235");
		userDTO2.setEndereco("Rua A");
		userDTO2.setEmail("leto@email.com");
		userDTO2.setTelefone("1234-1234");
		userDTO2.setDataCadastro(new Date());
						
		UserController.usuarios.add(userDTO);		
		UserController.usuarios.add(userDTO1);
		UserController.usuarios.add(userDTO2);
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return usuarios;
	}
	
	@GetMapping("/users/{cpf}")
	public UserDTO getUsersFiltro(@PathVariable String cpf) {
		//
		for (UserDTO userFilter:usuarios) {
			if (userFilter.getCpf().equals(cpf)) {
				//
				return userFilter;
			}
		}
		
		return null;
	}
	
	@PostMapping("/newuser")
	public UserDTO inserir(@RequestBody UserDTO userDTO) {
		userDTO.setDataCadastro(new Date());
		this.usuarios.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/users/removerUsuario/{cpf}")
	public boolean remover(@PathVariable String cpf) {
		//
		for (UserDTO userFilter:this.usuarios) {
			if (userFilter.getCpf().equals(cpf)) {
				this.usuarios.remove(userFilter);
				return true;
			}
		}
		
		
		return false;
	}
	
	
	
	
	
}

package com.eugenio.java.backend.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eugenio.java.backend.dto.UserDTO;
import com.eugenio.java.backend.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class UserController {
	//
    @Autowired
	private UserService userService;	
			
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		List<UserDTO> usuarios = userService.getAll();
		return usuarios;
	}
	
	@GetMapping("/users/{id}")
	UserDTO findById(@PathVariable long id) {
		return userService.findById(id);		
	}
	
	@GetMapping("/users/cpf/{cpf}")
	public UserDTO findByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}
	
	@PostMapping("/user")
	public UserDTO newUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@DeleteMapping("/users/{id}")
	public boolean delete(@PathVariable long id) throws UserPrincipalNotFoundException {
		//
		return userService.delete(id);
	}
	
	@GetMapping("/user/search")
	public List<UserDTO> queryByName(@RequestParam(name="nome", required = true) String nome){
		//
		return userService.queryByName(nome);
	}
	
	
	
}

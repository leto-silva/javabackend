package com.eugenio.java.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugenio.java.backend.dto.UserDTO;
import com.eugenio.java.backend.model.User;
import com.eugenio.java.backend.repository.UserRepository;

@Service
public class UserService {
	//
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> getAll(){
		//
		List<User> usuarios = userRepository.findAll();
		List<UserDTO> userDTO = usuarios.stream().map(UserDTO::convert).toList();
		return userDTO;
	}
	
	public UserDTO findById(long userId) {
		//
		Optional<User> usuario = userRepository.findById(userId);
		
		if (usuario.isPresent()) {
			return UserDTO.convert(usuario.get());
		}
		return null;		
	}
	
	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}
	
	public boolean delete(long userId) {
		//
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			userRepository.delete(user.get());
			return true;
		}
		
		return false;		
	}
	
	public UserDTO findByCpf(String cpf) {
		//
		User user = userRepository.findByCpf(cpf);
		if (user != null) {
			return UserDTO.convert(user);
		}
		return null;
	}
	
	public List<UserDTO> queryByName(String nome){
		//
		List<User> usuarios = userRepository.queryByNomeLike(nome);
		return usuarios.stream().map(UserDTO::convert).toList();
	}
}

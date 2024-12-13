package com.eugenio.java.backend.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import com.eugenio.java.backend.controller.UserController;
import com.eugenio.java.backend.model.User;

public class UserDTO {
	//	
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date dataCadastro;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	public static UserDTO convert(User usuarios) {
		//
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(usuarios.getNome());
		userDTO.setEndereco(usuarios.getEndereco());
		userDTO.setCpf(usuarios.getCpf());
		userDTO.setEmail(usuarios.getEmail());
		userDTO.setTelefone(usuarios.getTelefone());
		userDTO.setDataCadastro(usuarios.getDataCadastro());
		return userDTO;		
	}
	
	
	

}

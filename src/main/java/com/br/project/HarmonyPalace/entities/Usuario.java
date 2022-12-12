package com.br.project.HarmonyPalace.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "id_status")
	private Integer idStatus = 2;
	
	@Column(name = "id_acesso")
	private Integer idAcesso = 1;
	
	@NotBlank(message = "Por favor insira um e-mail válido!")
	@Email
	@Column(name = "email")
	private String  email;
	
	@NotBlank(message = "Por favor insira uma senha válida!")
	@Column(name = "senha")
	private String senha;
																//VALIDAÇÃO BÁSICA COM ANNOTATIONS DO SPRING, PORÉM FALTA TRATAR OS ERROS E TRABALHAR SEUS RETORNOS NO FRONT-END;
	@NotBlank(message = "Por favor insira um nome válido!")
	@Column(name = "nome")
	private String nome;
	
	@NotBlank(message = "Por favor insira um telefone válido!")
	@Column(name = "telefone")
	private String telefone;
	
	
	@Column(name = "apartamento")
	private Integer apartamento;
	
	@Column(name = "data_cadastro")
	LocalDateTime datahora = LocalDateTime.now();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public Integer getIdAcesso() {
		return idAcesso;
	}

	public void setIdAcesso(Integer idAcesso) {
		this.idAcesso = idAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getApartamento() {
		return apartamento;
	}

	public void setApartamento(Integer apartamento) {
		this.apartamento = apartamento;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}


}

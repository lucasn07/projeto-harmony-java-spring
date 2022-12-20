package com.br.project.HarmonyPalace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.project.HarmonyPalace.entities.Usuario;
import com.br.project.HarmonyPalace.repository.UsuarioInterface;

@Service
public class UsuarioService {

	private UsuarioInterface repository;
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioInterface repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
		
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Integer validarAcesso(Usuario usuario) {
		Integer idAcesso = repository.getReferenceByEmail(usuario.getEmail()).getIdAcesso();
		return idAcesso;
	}
	
		
	public Usuario criarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
	
	public Usuario validarEmail (Usuario usuario) {
		Usuario emailExistente = repository.getReferenceByEmail(usuario.getEmail());
		if (emailExistente != null) {
			throw new Error("Email já cadastrado!");
		}
		Usuario validEmail = repository.save(usuario);
		return validEmail;
	}
	
	public Boolean validarSenha(Usuario usuario) {
		String senha = repository.getReferenceByEmail(usuario.getEmail()).getSenha();
		Boolean comparação = passwordEncoder.matches(usuario.getSenha(), senha);
		return comparação;
	}
	
	
	
	
}
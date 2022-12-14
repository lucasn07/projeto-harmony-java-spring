package com.br.project.HarmonyPalace.service;

import java.util.List;

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
	
	public Boolean validarEmail (Usuario usuario) {
		Boolean validEmail = null;
		Usuario verificaEmail = repository.getReferenceByEmail(usuario.getEmail());
		Boolean validacao = (validEmail != null) ? false : true; 
		return validacao;
	}
	
	public Boolean validarLogin(Usuario usuario) {
		String validação = repository.getReferenceByEmail(usuario.getEmail()).getSenha();
		Boolean comparação = passwordEncoder.matches(usuario.getSenha(), validação);
		return comparação;
	}
	
	
	
	
}
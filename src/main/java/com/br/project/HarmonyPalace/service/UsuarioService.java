package com.br.project.HarmonyPalace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.project.HarmonyPalace.entities.Usuario;
import com.br.project.HarmonyPalace.repository.UsuarioInterface;

@Service
public class UsuarioService {

	private UsuarioInterface repository;
	
	public UsuarioService(UsuarioInterface repository) {
		this.repository = repository;
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
}
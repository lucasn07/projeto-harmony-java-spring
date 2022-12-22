package com.br.project.HarmonyPalace.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.project.HarmonyPalace.entities.Usuario;
import com.br.project.HarmonyPalace.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) { // Injeção de dependencia atraves de contrutor, sem
																// autowired
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuario() {
		return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
	}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) { // A annotation @valid serve para poder usar o @blank na classe
		Boolean validacao = usuarioService.validarEmail(usuario);
		if(validacao) {
			try {
				return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
			}
			catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // criar exception personalizada para não retornar um stastus 500 
			}	
		}
		return null; 
	}

	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();
	}

	@PostMapping("/login")
	public ResponseEntity<Integer> validarSenha(@RequestBody Usuario usuario) {
		
		try {
			Integer idAcesso = usuarioService.validarAcesso(usuario);
			Boolean validação = usuarioService.validarLogin(usuario);
			if (validação) {
				return ResponseEntity.ok(idAcesso);
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		} catch (NullPointerException e) {
			return ResponseEntity.status(400).build();
		}
	}

}

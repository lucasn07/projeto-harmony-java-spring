package com.br.project.HarmonyPalace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.br.project.HarmonyPalace.repository.UsuarioInterface;
import com.br.project.HarmonyPalace.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController{

	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping	
	public ResponseEntity<List<Usuario>> listarUsuario() {
		return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario (@RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuario));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> validarSenha(@RequestBody Usuario usuario) {
		Boolean validação = usuarioService.validarSenha(usuario);
		if (!validação ) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); //AINDA NÃO ESTÁ FUNCIONANDO COM O FRONT-END
		}
		return ResponseEntity.status(200).build();	
	}
	
}

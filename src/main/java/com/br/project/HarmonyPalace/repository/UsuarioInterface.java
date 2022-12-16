package com.br.project.HarmonyPalace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.project.HarmonyPalace.entities.Usuario;


public interface UsuarioInterface extends JpaRepository<Usuario, Integer> {

	Usuario getReferenceByEmail(String email);

}

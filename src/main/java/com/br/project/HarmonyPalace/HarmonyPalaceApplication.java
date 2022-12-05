package com.br.project.HarmonyPalace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HarmonyPalaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarmonyPalaceApplication.class, args);
		}

}

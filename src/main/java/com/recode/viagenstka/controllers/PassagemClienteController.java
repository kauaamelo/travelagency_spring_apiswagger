package com.recode.viagenstka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recode.viagenstka.entities.PassagemClienteDTO;
import com.recode.viagenstka.services.PassagemService;

@RestController
@RequestMapping("/infopassagem")
public class PassagemClienteController {
	
	@Autowired
	private PassagemService passagemser;
	
	@PostMapping("/infodecliente")
	public ResponseEntity<String> info(@RequestBody PassagemClienteDTO passcliDTO) {
		passagemser.info(passcliDTO.getIdPassagem(), passcliDTO.getIdCliente());
		return ResponseEntity.ok("Informações de cliente ok!");
	}
}

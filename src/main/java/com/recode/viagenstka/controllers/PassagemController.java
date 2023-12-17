package com.recode.viagenstka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recode.viagenstka.entities.Passagem;
import com.recode.viagenstka.services.PassagemService;

@RestController
@RequestMapping("/passagem")
public class PassagemController {
	
	   @Autowired
	    private PassagemService passagemRep;
	   
	   @PostMapping("/salvarpassagem")
	    public ResponseEntity<Passagem> criarPassagem(@RequestBody Passagem passagem) {
	        Passagem novaPassagem = passagemRep.savePassagem(passagem);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novaPassagem);
	    }
	   
	   @GetMapping("/listapassagem")
	    public List<Passagem> getAllPassagem() {
	        return passagemRep.getAllPassagem();
	    }
	   
	   @GetMapping("/{idPassagem}")
	    public ResponseEntity<Passagem> getPassagemById(@PathVariable Long idPassagem) {
	        try {
	            Passagem passagem = passagemRep.getPassagemById(idPassagem);
	            return ResponseEntity.ok(passagem);
	        } catch (RuntimeException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	   
	   @PutMapping("/{idPassagem}")
	    public ResponseEntity<Passagem> updatePassagem(@PathVariable Long idPassagem, @RequestBody Passagem passagemUpdate) {
	        try {
	            Passagem passagem = passagemRep.updatePassagem(idPassagem, passagemUpdate);
	            return ResponseEntity.ok(passagem);
	        } catch (RuntimeException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	   @DeleteMapping("/{idPassagem}")
	    public ResponseEntity<Void> deletePassagem(@PathVariable Long idPassagem) {
		   passagemRep.deleteById(idPassagem);
	        return ResponseEntity.noContent().build();
	    }
	   
	   
}

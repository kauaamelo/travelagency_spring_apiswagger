package com.recode.viagenstka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recode.viagenstka.entities.Cliente;
import com.recode.viagenstka.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteRep;

	@PostMapping("/salvarcliente")
	public Cliente criarCliente (@RequestBody Cliente cliente ) {
		return clienteRep.saveCliente(cliente);
	}
	
	@GetMapping("/listacliente")
	public List<Cliente> getAllCliente() {
		return clienteRep.getAllCliente();
	}
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long idCliente){
		Cliente cliente = clienteRep.getClienteById(idCliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/{idCliente}")
	public ResponseEntity<Cliente> uptadeCliente (@PathVariable Long idCliente, @RequestBody Cliente clienteUptade){
		Cliente cliente = clienteRep.getClienteById(idCliente);
		cliente.setNomeCompleto(clienteUptade.getNomeCompleto());
		clienteRep.saveCliente(cliente);
		
		return ResponseEntity.ok(cliente);
		
	}
	
	@DeleteMapping("/{idCliente}")
	public void deleteCliente(@PathVariable Long idCliente) {
		clienteRep.deleteById(idCliente);
	}
}

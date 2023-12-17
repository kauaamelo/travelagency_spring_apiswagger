package com.recode.viagenstka.services;

import java.util.List;
import com.recode.viagenstka.entities.Cliente;

public interface ClienteService {

	List<Cliente> getAllCliente();
	
	Cliente getClienteById(Long idCliente);
	
	Cliente saveCliente (Cliente cliente);
	
	Cliente updateCliente(Long idCliente, Cliente clienteUptade);
	
	void deleteById(Long idCliente);
	
}

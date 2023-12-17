package com.recode.viagenstka.servicesimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.viagenstka.entities.Cliente;
import com.recode.viagenstka.repositories.ClienteRepository;
import com.recode.viagenstka.services.ClienteService;

@Service
public class ClienteServiceimpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRep;

	@Override
	public List<Cliente> getAllCliente() {
		
		return clienteRep.findAll();
	}

	@Override
	public Cliente getClienteById(Long idCliente) {
		
		return clienteRep.findById(idCliente)
		.orElseThrow(()-> new RuntimeException("Erro no ID: " + idCliente));
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		
		return clienteRep.save(cliente);
	}

	@Override
	public Cliente updateCliente(Long idCliente, Cliente clienteUpdate) {
		
		Cliente clienteExistente = clienteRep.findById(idCliente)
		.orElseThrow(()-> new RuntimeException("Erro no ID: " + idCliente));
		
		//Copia as propriedades de um objeto para outro.
		BeanUtils.copyProperties(clienteUpdate, clienteExistente, "idCliente");
		return clienteRep.save(clienteExistente);
	}

	@Override
	public void deleteById(Long idCliente) {
	    if (clienteRep.existsById(idCliente)) {
	        clienteRep.deleteById(idCliente);
	    } else {
	        throw new RuntimeException("Cliente com ID: " + idCliente + "não encontrado.");
	    }
	}
	
}

package com.recode.viagenstka.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recode.viagenstka.entities.Cliente;
import com.recode.viagenstka.entities.Passagem;
import com.recode.viagenstka.repositories.ClienteRepository;
import com.recode.viagenstka.repositories.PassagemRepository;
import com.recode.viagenstka.services.PassagemService;

@Service
public class PassagemServiceimpl implements PassagemService {
	
	@Autowired
	private PassagemRepository passagemRep;
	@Autowired
	private ClienteRepository clienteRep;

	@Override
	public List<Passagem> getAllPassagem() {
		
		return passagemRep.findAll();
	}

	@Override
	public Passagem getPassagemById(Long idPassagem) {
		
		return passagemRep.findById(idPassagem).orElseThrow(()-> new RuntimeException("Erro: " + idPassagem));
	}

	@Override
	public Passagem savePassagem(Passagem passagem) {
		
		return passagemRep.save(passagem);
	}

	@Override
	public Passagem updatePassagem(Long idPassagem, Passagem passagemUptade) {
		
		Passagem passagemExistente = passagemRep.findById(idPassagem).orElseThrow(()-> new RuntimeException("Erro: " + idPassagem));
		passagemExistente.setDestino(passagemUptade.getDestino());
		return passagemRep.save(passagemExistente);
	}

	@Override
	public void deleteById(Long idPassagem) {
		
		passagemRep.deleteById(idPassagem);
	
	}

	@Override
	public void info(Long idPassagem, Long idCliente) {
		Passagem passagem = passagemRep.findById(idPassagem).orElseThrow(()-> new RuntimeException("Erro: " + idPassagem));
		Cliente cliente = clienteRep.findById(idCliente).orElseThrow(()-> new RuntimeException("Erro: " + idCliente));
				
		passagem.setCliente(cliente);
		passagemRep.save(passagem);
			
		}
}

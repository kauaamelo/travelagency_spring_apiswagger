package com.recode.viagenstka.services;

import java.util.List;
import com.recode.viagenstka.entities.Passagem;

public interface PassagemService {

	List<Passagem> getAllPassagem();
	
	Passagem getPassagemById(Long idPassagem);
	
	Passagem savePassagem (Passagem Passagem);
	
	Passagem updatePassagem(Long idPassagem, Passagem passagemUptade);
	
	void deleteById(Long idPassagem);

	void info(Long idPassagem, Long idCliente);
	
}

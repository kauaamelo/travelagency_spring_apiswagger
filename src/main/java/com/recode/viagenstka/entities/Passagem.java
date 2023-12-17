package com.recode.viagenstka.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_passagem")
public class Passagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassagem;
	
	private String destino;
	private String promocao;
	private String horario;
	private LocalDate dataViagem; 
	private String preco;

	@JsonIgnore
	@ManyToOne (cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_idCliente")
	private Cliente cliente;
		public Passagem(Long idPassagem, String destino, String promocao, String horario, LocalDate dataViagem,
			String preco, Cliente cliente) {
		super();
		this.idPassagem = idPassagem;
		this.destino = destino;
		this.promocao = promocao;
		this.horario = horario;
		this.dataViagem = dataViagem;
		this.preco = preco;
		this.cliente = cliente;
	}

	public Passagem() {
		
	}

	public Long getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(Long idPassagem) {
		this.idPassagem = idPassagem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public LocalDate getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(LocalDate dataViagem) {
		this.dataViagem = dataViagem;
	}

	public String getPreço() {
		return preco;
	}

	public void setPreço(String preco) {
		this.preco = preco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}

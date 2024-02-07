package com.coelho.rinha.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long limite;

	private Long saldo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("cliente")
	private List<Transacao> ultimas_transacoes;

	public List<Transacao> getUltimas_transacoes() {
		return ultimas_transacoes;
	}

	public void setUltimas_transacoes(List<Transacao> ultimas_transacoes) {
		this.ultimas_transacoes = ultimas_transacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLimite() {
		return limite;
	}

	public void setLimite(Long limite) {
		this.limite = limite;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

}

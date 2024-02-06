package com.coelho.rinha.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name ="tb_clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long limite;
	
	private Long saldo;
	
	@UpdateTimestamp
	private LocalDateTime realizada_em;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("cliente")
	private Transacao transacao;
	
	

	public LocalDateTime getRealizada_em() {	return realizada_em;}
	
	public void setRealizada_em(LocalDateTime realizada_em) {	this.realizada_em = realizada_em;}

	public Transacao getTransacao() {return transacao;}

	public void setTransacao(Transacao transacao) {	this.transacao = transacao;}

	public Long getId() {return id;}

	public void setId(Long id) {	this.id = id;}

	public Long getLimite() {	return limite;}

	public void setLimite(Long limite) {	this.limite = limite;}

	public Long getSaldo() {	return saldo;}

	public void setSaldo(Long saldo) {	this.saldo = saldo;}
	
	
}

package com.coelho.rinha.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transacoes")
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long valor;
	
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipo;
	
	@Size(max = 10)
	private String descricao;
	
	@ManyToOne
	@JsonIgnoreProperties("ultimas_transacoes")
	private Cliente id_cliente;
	
	@UpdateTimestamp
	private LocalDateTime realizada_em;
	
	
	

	public LocalDateTime getRealizada_em() {	return realizada_em;}

	public void setRealizada_em(LocalDateTime realizada_em) {	this.realizada_em = realizada_em;}

	public Cliente getId_cliente() {	return id_cliente;}

	public void setId_cliente(Cliente id_cliente) {this.id_cliente = id_cliente;}

	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public Long getValor() {return valor;}

	public void setValor(Long valor) {this.valor = valor;}

	public TipoTransacao getTipo() {return tipo;}

	public void setTipo(TipoTransacao tipo) {this.tipo = tipo;}

	public String getDescricao() {return descricao;}

	public void setDescricao(String descricao) {this.descricao = descricao;}

}

enum TipoTransacao{
	c, d
}

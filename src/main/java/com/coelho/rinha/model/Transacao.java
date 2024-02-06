package com.coelho.rinha.model;

import javax.validation.constraints.Size;

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
	@JsonIgnoreProperties("transacao")
	private Cliente id_cliente;
	
	
	

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

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

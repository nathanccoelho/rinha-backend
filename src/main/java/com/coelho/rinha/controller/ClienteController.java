package com.coelho.rinha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coelho.rinha.model.Cliente;
import com.coelho.rinha.model.Transacao;
import com.coelho.rinha.repository.ClienteRepository;
import com.coelho.rinha.repository.TransacaoRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
		
	}
	
	@PostMapping("/{id}/transacoes")
	public ResponseEntity<Transacao> realizarTransacao(@Valid @RequestBody @PathVariable Long id, Transacao transacao){
		return ResponseEntity.status(HttpStatus.CREATED).body(transacaoRepository.save(transacao));
	}
}

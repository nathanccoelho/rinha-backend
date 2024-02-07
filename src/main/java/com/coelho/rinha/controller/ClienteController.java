package com.coelho.rinha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coelho.rinha.model.Cliente;
import com.coelho.rinha.model.Transacao;
import com.coelho.rinha.repository.ClienteRepository;
import com.coelho.rinha.repository.TransacaoRepository;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente){
		return ResponseEntity.ok().body(clienteRepository.save(cliente));
		
	}
	
	@PostMapping("/{id}/transacoes")
	public ResponseEntity<Transacao> realizarTransacao(@Valid @RequestBody Transacao transacao, @PathVariable Long id){
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

		Long novoSaldo = cliente.getSaldo()-transacao.getValor();

		cliente.setSaldo(novoSaldo);
		if (novoSaldo < -cliente.getLimite()){
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(transacao);
		}


		transacao.setId_cliente(cliente);


		return ResponseEntity.ok().body(transacaoRepository.save(transacao));

	}

	@GetMapping("{id}/extrato")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
			return clienteRepository.findById(id).map(resposta ->ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
	}
}

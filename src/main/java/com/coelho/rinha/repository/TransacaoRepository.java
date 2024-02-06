package com.coelho.rinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coelho.rinha.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}

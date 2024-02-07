package com.coelho.rinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coelho.rinha.model.Transacao;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}

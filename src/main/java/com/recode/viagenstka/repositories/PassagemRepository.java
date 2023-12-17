package com.recode.viagenstka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recode.viagenstka.entities.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO fk_idCliente (cliente_idCliente, passagem_idPassagem) VALUES (:idCliente, :idPassagem)")
    void info(@Param("idPassagem") Long idPassagem, @Param("idCliente") Long idCliente);

}
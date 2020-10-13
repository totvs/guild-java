package com.totvs.guildjava.construcaoobjetos.cliente.infra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.totvs.guildjava.construcaoobjetos.cliente.dominio.Cliente;
import com.totvs.guildjava.construcaoobjetos.cliente.dominio.ClienteRepository;

@Repository
public interface ClienteJpaRepository extends ClienteRepository, CrudRepository<Cliente, String> {

}

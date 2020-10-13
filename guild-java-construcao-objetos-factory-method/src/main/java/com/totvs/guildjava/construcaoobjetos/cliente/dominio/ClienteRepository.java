package com.totvs.guildjava.construcaoobjetos.cliente.dominio;

import java.util.Optional;

public interface ClienteRepository {

	Optional<Cliente> findById(String id);

	Cliente save(Cliente cliente);
}

package com.totvs.guildjava.construcaoobjetos.cliente.app;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.totvs.guildjava.construcaoobjetos.cliente.dominio.Cliente;
import com.totvs.guildjava.construcaoobjetos.cliente.dominio.ClienteRepository;
import com.totvs.guildjava.construcaoobjetos.cliente.dominio.SituacaoCliente;
import com.totvs.guildjava.construcaoobjetos.pedido.dominio.Pedido;
import com.totvs.guildjava.construcaoobjetos.pedido.dominio.PedidoRepository;

@Transactional
@SpringBootTest
class ClienteServiceIT {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteService clienteService;

	@Test
	@DisplayName("Deve criar pedido para o cliente")
	void deveCriarPedidoParaOCliente() {

		// given
		Cliente cliente = new Cliente("MURILO", SituacaoCliente.ATIVO);
		clienteRepository.save(cliente);

		CriarPedido criarPedido = new CriarPedido(cliente.getId());

		// when
		String pedidoId = clienteService.handle(criarPedido);

		// then
		Optional<Pedido> novoPedido = pedidoRepository.findById(pedidoId);

		assertFalse(novoPedido.isEmpty());
	}
}

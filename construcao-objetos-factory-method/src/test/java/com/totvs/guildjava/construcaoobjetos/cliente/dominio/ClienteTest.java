package com.totvs.guildjava.construcaoobjetos.cliente.dominio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.totvs.guildjava.construcaoobjetos.cliente.dominio.Cliente;
import com.totvs.guildjava.construcaoobjetos.cliente.dominio.SituacaoCliente;
import com.totvs.guildjava.construcaoobjetos.pedido.dominio.Pedido;

class ClienteTest {

	@Test
	@DisplayName("Quando cliente ativo, pedido de ser criado como aprovado")
	void quandoClienteAtivoPedidoDeveSerCriadoAprovado() {

		// given
		Cliente cliente = new Cliente("MURILO", SituacaoCliente.ATIVO);

		// when
		Pedido pedido = cliente.criarPedido();

		// then
		assertThat(pedido.isAprovado()).isTrue();
	}

	@Test
	@DisplayName("Quando cliente inativo, pedido de ser criado como aprovado")
	void quandoClienteInativoPedidoDeveSerCriadoAguardandoAprovacao() {

		// given
		Cliente cliente = new Cliente("MURILO", SituacaoCliente.INATIVO);

		// when
		Pedido pedido = cliente.criarPedido();

		// then
		assertThat(pedido.isAguardandoAprovacao()).isTrue();
	}

}

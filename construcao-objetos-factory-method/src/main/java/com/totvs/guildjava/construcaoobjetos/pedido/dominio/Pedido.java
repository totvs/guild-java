package com.totvs.guildjava.construcaoobjetos.pedido.dominio;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido {

	@Id
	private String id;

	private String clienteId;

	/*
	 * Poderiam existir outras propriedades, como itens, valores, entrega etc...
	 */

	private SituacaoPedido situacao;

	Pedido() {}

	public Pedido(String clienteId, SituacaoPedido situacao) {
		this.id = UUID.randomUUID().toString();
		this.clienteId = clienteId;
		this.situacao = situacao;
	}

	public static Pedido aprovado(String clienteId) {
		return new Pedido(clienteId, SituacaoPedido.APROVADO);
	}

	public static Pedido aguardandoAprovacao(String clienteId) {
		return new Pedido(clienteId, SituacaoPedido.AGUARDANDO_APROVACAO);
	}

	public String getId() {
		return id;
	}

	public String getClienteId() {
		return clienteId;
	}

	public boolean isAprovado() {
		return this.situacao.equals(SituacaoPedido.APROVADO);
	}

	public boolean isAguardandoAprovacao() {
		return this.situacao.equals(SituacaoPedido.AGUARDANDO_APROVACAO);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.id, obj);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + clienteId + ", situacao=" + situacao + "]";
	}
}
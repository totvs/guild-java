package com.totvs.guildjava.construcaoobjetos.cliente.app;

import java.util.Objects;

public final class CriarPedido {

	private final String clienteId;

	public CriarPedido(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteId() {
		return clienteId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.clienteId);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.clienteId, obj);
	}

	@Override
	public String toString() {
		return "CriarPedido [clienteId=" + clienteId + "]";
	}

}

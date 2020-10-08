package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.util.Objects;

public class CaracteristicaValorTexto implements CaracteristicaValor<String> {

	private String caracteristicaId;
	private String valor;

	protected CaracteristicaValorTexto() {}

	protected CaracteristicaValorTexto(String id, String valor) {
		this.caracteristicaId = id;
		this.valor = valor;
	}

	@Override
	public String getCaracteristicaId() {
		return caracteristicaId;
	}

	@Override
	public String getValor() {
		return valor;
	}

	@Override
	public CaracteristicaValorTipo getTipo() {
		return CaracteristicaValorTipo.TEXTO;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.caracteristicaId);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.caracteristicaId, obj);
	}

	@Override
	public int compareTo(CaracteristicaValor<String> o) {
		return this.getValor().compareTo(o.getValor());
	}

	@Override
	public String toString() {
		return "ValorTexto [id=" + caracteristicaId + ", valor=" + valor + "]";
	}

}

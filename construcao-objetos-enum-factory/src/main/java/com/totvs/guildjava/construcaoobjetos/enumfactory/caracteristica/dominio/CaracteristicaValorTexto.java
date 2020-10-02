package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.util.Objects;

public class CaracteristicaValorTexto implements CaracteristicaValor<String> {

	private String id;
	private String valor;

	protected CaracteristicaValorTexto(String id, String valor) {
		this.id = id;
		this.valor = valor;
	}

	@Override
	public String getId() {
		return id;
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
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.id, obj);
	}

	@Override
	public int compareTo(CaracteristicaValor<String> o) {
		return this.getValor().compareTo(o.getValor());
	}

	@Override
	public String toString() {
		return "ValorTexto [id=" + id + ", valor=" + valor + "]";
	}

}

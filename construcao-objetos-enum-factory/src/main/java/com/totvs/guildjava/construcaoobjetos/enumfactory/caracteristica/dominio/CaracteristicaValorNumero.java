package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.math.BigDecimal;
import java.util.Objects;

public class CaracteristicaValorNumero implements CaracteristicaValor<BigDecimal> {

	private String id;
	private BigDecimal valor;

	protected CaracteristicaValorNumero(String id, BigDecimal valor) {
		this.id = id;
		this.valor = valor;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public CaracteristicaValorTipo getTipo() {
		return CaracteristicaValorTipo.NUMERO;
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
	public int compareTo(CaracteristicaValor<BigDecimal> o) {
		return this.getValor().compareTo(o.getValor());
	}

	@Override
	public String toString() {
		return "ValorNumero [id=" + id + ", valor=" + valor + "]";
	}

}

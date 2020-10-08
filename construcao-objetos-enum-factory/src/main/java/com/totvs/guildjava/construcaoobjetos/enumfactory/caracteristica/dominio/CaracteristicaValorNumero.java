package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.math.BigDecimal;
import java.util.Objects;

public class CaracteristicaValorNumero implements CaracteristicaValor<BigDecimal> {

	private String caracteristicaId;
	private BigDecimal valor;

	protected CaracteristicaValorNumero() {}

	protected CaracteristicaValorNumero(String id, BigDecimal valor) {
		this.caracteristicaId = id;
		this.valor = valor;
	}

	@Override
	public String getCaracteristicaId() {
		return caracteristicaId;
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
		return Objects.hashCode(this.caracteristicaId);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.caracteristicaId, obj);
	}

	@Override
	public int compareTo(CaracteristicaValor<BigDecimal> o) {
		return this.getValor().compareTo(o.getValor());
	}

	@Override
	public String toString() {
		return "ValorNumero [id=" + caracteristicaId + ", valor=" + valor + "]";
	}

}

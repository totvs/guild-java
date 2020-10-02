package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class CaracteristicaValorData implements CaracteristicaValor<LocalDate> {

	private String id;
	private LocalDate valor;

	protected CaracteristicaValorData(String id, LocalDate valor) {
		this.id = id;
		this.valor = valor;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public LocalDate getValor() {
		return valor;
	}

	@Override
	public CaracteristicaValorTipo getTipo() {
		return CaracteristicaValorTipo.DATA;
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
	public int compareTo(CaracteristicaValor<LocalDate> o) {
		return this.getValor().compareTo(o.getValor());
	}

	@Override
	public String toString() {
		return "ValorData [id=" + id + ", valor=" + valor + "]";
	}

}

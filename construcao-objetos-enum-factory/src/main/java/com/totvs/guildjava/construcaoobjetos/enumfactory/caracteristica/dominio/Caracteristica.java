package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.util.Objects;

public class Caracteristica {

	private String id;

	private String nome;

	private CaracteristicaValorTipo tipoValor;

	public Caracteristica() {}

	public Caracteristica(String id, String nome, CaracteristicaValorTipo formato) {
		this.id = id;
		this.nome = nome;
		this.tipoValor = formato;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public CaracteristicaValorTipo getTipoValor() {
		return tipoValor;
	}

	public CaracteristicaValor<?> valor(String valor) {
		return this.getTipoValor().createInstance(this.id, valor);
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
		return "Configuracao [id=" + id + ", nome=" + nome + ", formato=" + tipoValor + "]";
	}
}

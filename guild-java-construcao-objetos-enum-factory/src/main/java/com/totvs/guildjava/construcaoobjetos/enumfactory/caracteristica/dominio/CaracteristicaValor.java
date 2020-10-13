package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

public interface CaracteristicaValor<T> extends Comparable<CaracteristicaValor<T>> {

	String getCaracteristicaId();

	T getValor();

	CaracteristicaValorTipo getTipo();
}

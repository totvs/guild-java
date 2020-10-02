package com.totvs.guildjava.construcaoobjetos.enumfactory.estoque.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio.CaracteristicaValor;

public class Estoque {

	private String id;

	private String produtoId;

	private List<CaracteristicaValor<?>> caracteristicasValor;

	private BigDecimal saldo;

	public Estoque(String id, String produtoId, List<CaracteristicaValor<?>> caracteristicasValor, BigDecimal saldo) {
		this.id = id;
		this.produtoId = produtoId;
		this.caracteristicasValor = caracteristicasValor;
		this.saldo = saldo;
	}

	public String getId() {
		return id;
	}

	public String getProdutoId() {
		return produtoId;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public List<CaracteristicaValor<?>> getCaracteristicasValor() {
		return caracteristicasValor;
	}

	public CaracteristicaValor<?> getCaracteristicaValor(String id) {
		return this.getCaracteristicasValor().stream().filter(cv -> cv.getId().equals(id)).findFirst().orElseThrow();
	}

	public static EstoqueBuilder builder() {
		return new EstoqueBuilder();
	}

	public static class EstoqueBuilder {

		private String id;

		private String produtoId;

		private List<CaracteristicaValor<?>> caracteristicasValor = new ArrayList<>();

		private BigDecimal quantidade;

		private EstoqueBuilder() {}

		public EstoqueBuilder id(String id) {
			this.id = id;
			return this;
		}

		public EstoqueBuilder produtoId(String produtoId) {
			this.produtoId = produtoId;
			return this;
		}

		public EstoqueBuilder caracteristicas(List<CaracteristicaValor<?>> caracteristicasValor) {
			this.caracteristicasValor.addAll(caracteristicasValor);
			return this;
		}

		public EstoqueBuilder quantidade(BigDecimal quantidade) {
			this.quantidade = quantidade;
			return this;
		}

		public Estoque build() {
			return new Estoque(this.id, this.produtoId, this.caracteristicasValor, this.quantidade);
		}
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
		return "Estoque [id=" + id + ", produtoId=" + produtoId + ", caracteristicas=" + caracteristicasValor
		        + ", saldo=" + saldo + "]";
	}
}

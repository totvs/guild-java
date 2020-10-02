package com.totvs.guildjava.construcaoobjetos.enumfactory.estoque.dominio;

import static com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio.CaracteristicaValorTipo.DATA;
import static com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio.CaracteristicaValorTipo.NUMERO;
import static com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio.CaracteristicaValorTipo.TEXTO;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio.Caracteristica;
import com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio.CaracteristicaValor;
import com.totvs.guildjava.construcaoobjetos.enumfactory.estoque.dominio.EstoqueTest.EntradaEstoqueDTO.CaracteristicaValorDTO;

class EstoqueTest {

	@Test
	void testeOrdenacaoEstoque() {

		/*
		 * lista que servirá para simular um conjunto de produtos no estoue
		 */
		List<Estoque> estoques = new ArrayList<>();

		/*
		 * um conjunto de características pré cadastradas
		 */
		List<Caracteristica> caracteristicas = new ArrayList<>();

		Caracteristica lote = new Caracteristica(randomUUID().toString(), "LOTE", TEXTO);
		caracteristicas.add(lote);

		Caracteristica dataValidade = new Caracteristica(randomUUID().toString(), "DATA VALIDADE", DATA);
		caracteristicas.add(dataValidade);

		Caracteristica indiceFragilidade = new Caracteristica(randomUUID().toString(), "ÍNDICE FRAGILIDADE", NUMERO);
		caracteristicas.add(indiceFragilidade);

		/*
		 * ----- primeira entrada no estoque com os valores para cada característica
		 */
		EntradaEstoqueDTO primeiraEntradaEstoqueDTO = new EntradaEstoqueDTO();

		primeiraEntradaEstoqueDTO.produtoId = randomUUID().toString();

		primeiraEntradaEstoqueDTO.caracteristicasValor.add(new CaracteristicaValorDTO(lote.getId(), "LOTE Z"));
		primeiraEntradaEstoqueDTO.caracteristicasValor.add(new CaracteristicaValorDTO(dataValidade.getId(), "2021-12-31"));
		primeiraEntradaEstoqueDTO.caracteristicasValor.add(new CaracteristicaValorDTO(indiceFragilidade.getId(),
		                                                                              "1.3"));

		primeiraEntradaEstoqueDTO.quantidade = BigDecimal.TEN;

		List<CaracteristicaValor<?>> cvPrimeiraEntrada = primeiraEntradaEstoqueDTO.caracteristicasValor.stream().map(cvDTO -> {

			Caracteristica caracteristica = caracteristicas.stream()
			                                               .filter(c -> c.getId().equals(cvDTO.caracteristicaId))
			                                               .findFirst()
			                                               .orElseThrow();

			return caracteristica.valor(cvDTO.valor);

		}).collect(toList());

		var estoque01 = Estoque.builder()
		                       .id(randomUUID().toString())
		                       .produtoId(primeiraEntradaEstoqueDTO.produtoId)
		                       .quantidade(primeiraEntradaEstoqueDTO.quantidade)
		                       .caracteristicas(cvPrimeiraEntrada)
		                       .build();

		estoques.add(estoque01);

		/*
		 * ----- segunda entrada no estoque com os valores para cada característica
		 */

		EntradaEstoqueDTO segundaEntradaEstoqueDTO = new EntradaEstoqueDTO();

		segundaEntradaEstoqueDTO.produtoId = randomUUID().toString();

		segundaEntradaEstoqueDTO.caracteristicasValor.add(new CaracteristicaValorDTO(lote.getId(), "LOTE A"));
		segundaEntradaEstoqueDTO.caracteristicasValor.add(new CaracteristicaValorDTO(dataValidade.getId(), "2020-12-31"));
		segundaEntradaEstoqueDTO.caracteristicasValor.add(new CaracteristicaValorDTO(indiceFragilidade.getId(), "1.1"));

		segundaEntradaEstoqueDTO.quantidade = BigDecimal.TEN;

		List<CaracteristicaValor<?>> cvSegundaEntrada = segundaEntradaEstoqueDTO.caracteristicasValor.stream().map(cvDTO -> {

			Caracteristica caracteristica = caracteristicas.stream()
			                                               .filter(c -> c.getId().equals(cvDTO.caracteristicaId))
			                                               .findFirst()
			                                               .orElseThrow();

			return caracteristica.valor(cvDTO.valor);

		}).collect(toList());

		var estoque02 = Estoque.builder()
		                       .id(randomUUID().toString())
		                       .produtoId(segundaEntradaEstoqueDTO.produtoId)
		                       .quantidade(segundaEntradaEstoqueDTO.quantidade)
		                       .caracteristicas(cvSegundaEntrada)
		                       .build();

		estoques.add(estoque02);

		/*
		 * 
		 */
		assertThat(estoque01.getId()).isEqualTo(estoques.get(0).getId());
		assertThat(estoque02.getId()).isEqualTo(estoques.get(1).getId());

		estoques.sort(Comparator.comparing(e -> e.getCaracteristicaValor(dataValidade.getId())));

		assertThat(estoque02.getId()).isEqualTo(estoques.get(0).getId());
		assertThat(estoque01.getId()).isEqualTo(estoques.get(1).getId());

	}

	static final class EntradaEstoqueDTO {
		public String produtoId;
		public List<CaracteristicaValorDTO> caracteristicasValor = new ArrayList<>();
		public BigDecimal quantidade;

		static final class CaracteristicaValorDTO {
			public String caracteristicaId;
			public String valor;

			public CaracteristicaValorDTO(String caracteristicaId, String valor) {
				this.caracteristicaId = caracteristicaId;
				this.valor = valor;
			}
		}
	}

}

package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum CaracteristicaValorTipo {

	TEXTO {

		@Override
		public CaracteristicaValorTexto createInstance(String caracteristicaId, String valor) {
			return new CaracteristicaValorTexto(caracteristicaId, valor);
		}

	},

	NUMERO {

		@Override
		public CaracteristicaValorNumero createInstance(String caracteristicaId, String valor) {
			return new CaracteristicaValorNumero(caracteristicaId, new BigDecimal(valor));
		}

	},

	DATA {

		@Override
		public CaracteristicaValorData createInstance(String caracteristicaId, String valor) {
			return new CaracteristicaValorData(caracteristicaId, LocalDate.parse(valor));
		}

	};

	public abstract CaracteristicaValor<?> createInstance(String caracteristicaId, String valor);

}

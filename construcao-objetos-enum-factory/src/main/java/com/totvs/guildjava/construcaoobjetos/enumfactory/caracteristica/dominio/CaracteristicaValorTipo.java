package com.totvs.guildjava.construcaoobjetos.enumfactory.caracteristica.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public enum CaracteristicaValorTipo {

	TEXTO {

		@Override
		public CaracteristicaValorTexto createInstance(String id, String valor) {
			return new CaracteristicaValorTexto(id, valor);
		}

	},

	NUMERO {

		@Override
		public CaracteristicaValorNumero createInstance(String id, String valor) {
			return new CaracteristicaValorNumero(id, new BigDecimal(valor));
		}

	},

	DATA {

		@Override
		public CaracteristicaValorData createInstance(String id, String valor) {
			return new CaracteristicaValorData(id, LocalDate.parse(valor));
		}

	};

	public abstract CaracteristicaValor<?> createInstance(String id, String valor);

}

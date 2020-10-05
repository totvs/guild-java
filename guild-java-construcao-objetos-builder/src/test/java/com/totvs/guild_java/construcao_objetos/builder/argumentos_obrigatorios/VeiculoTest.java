package com.totvs.guild_java.construcao_objetos.builder.argumentos_obrigatorios;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VeiculoTest {

    @Test
    void test() {
        Veiculo veiculo = Veiculo.builder("Sandero")
                .anoFabricacao(Year.of(2016))
                .anoModelo(Year.of(2017))
                .fabricante("Renault")
                .placa("ABC-1234")
                .build();
        assertEquals("Sandero", veiculo.getModelo());
        assertEquals(Year.of(2016), veiculo.getAnoFabricacao());
        assertEquals(Year.of(2017), veiculo.getAnoModelo());
        assertEquals("Renault", veiculo.getFabricante());
        assertEquals("ABC-1234", veiculo.getPlaca());
    }
}

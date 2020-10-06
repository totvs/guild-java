package com.totvs.guild_java.construcao_objetos.builder.exemplo_comum;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {

    @Test
    void test() {
        Pessoa pessoa = Pessoa.builder()
                .dataNascimento(LocalDate.of(1990, Month.MAY, 2))
                .documento("123456")
                .nome("João")
                .nomeDaMae("Maria")
                .nomeDoPai("José")
                .sobrenome(null)
                .build();
        assertEquals(LocalDate.of(1990, Month.MAY, 2), pessoa.getDataNascimento());
        assertEquals("123456", pessoa.getDocumento());
        assertEquals("João", pessoa.getNome());
        assertEquals("Silva", pessoa.getSobrenome());
        assertEquals("Maria", pessoa.getNomeDaMae());
        assertEquals("José", pessoa.getNomeDoPai());
    }
}

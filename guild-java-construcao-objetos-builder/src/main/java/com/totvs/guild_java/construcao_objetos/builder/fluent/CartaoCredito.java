package com.totvs.guild_java.construcao_objetos.builder.fluent;

import java.time.YearMonth;

public class CartaoCredito {
    private final String numero;
    private final String nome;
    private final YearMonth validade;
    private final String codigoSeguranca;

    public CartaoCredito(String numero, String nome, YearMonth validade, String codigoSeguranca) {
        this.numero = numero;
        this.nome = nome;
        this.validade = validade;
        this.codigoSeguranca = codigoSeguranca;
    }
}

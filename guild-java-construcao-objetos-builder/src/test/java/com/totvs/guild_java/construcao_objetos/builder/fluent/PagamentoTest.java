package com.totvs.guild_java.construcao_objetos.builder.fluent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

class PagamentoTest {

    @Test
    void boleto() {
        Pagamento pagamento = Pagamento.builder()
                .boleto()
                .valor(BigDecimal.valueOf(100.50))
                .vencimento(LocalDate.now().plusDays(4))
                .build();
        Assertions.assertNotNull(pagamento);
    }

    @Test
    void cartao() {
        CartaoCredito cartaoCredito = new CartaoCredito("1234-1234-1234-1234", "JOÃO DA SILVA", YearMonth.of(2020, 12), "123");
        Pagamento pagamento = Pagamento.builder()
                .cartao(cartaoCredito)
                .valor(BigDecimal.valueOf(200))
                .parcelas(6)
                .build();
        Assertions.assertNotNull(pagamento);
    }
}

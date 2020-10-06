package com.totvs.guild_java.construcao_objetos.builder.fluent;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagamento {
    private BigDecimal valor;
    private LocalDate vencimento;
    private CartaoCredito cartaoCredito;
    private int parcelas;

    private Pagamento() {
    }

    public static PagamentoBuilder builder() {
        return new PagamentoBuilder();
    }

    public static class PagamentoBuilder {
        private PagamentoBuilder() {
        }

        public PagamentoBoletoBuilder boleto() {
            return new PagamentoBoletoBuilder(new Pagamento());
        }

        public PagamentoCartaoBuilder cartao(CartaoCredito cartaoCredito) {
            return new PagamentoCartaoBuilder(new Pagamento(), cartaoCredito);
        }
    }

    public static class PagamentoBoletoBuilder {
        private Pagamento pagamento;

        private PagamentoBoletoBuilder(Pagamento pagamento) {
            this.pagamento = pagamento;
            this.pagamento.parcelas = 1;
        }

        public PagamentoBoletoVencimentoBuilder valor(BigDecimal valor) {
            pagamento.valor = valor;
            return new PagamentoBoletoVencimentoBuilder(pagamento);
        }
    }

    public static class PagamentoBoletoVencimentoBuilder {
        private Pagamento pagamento;

        private PagamentoBoletoVencimentoBuilder(Pagamento pagamento) {
            this.pagamento = pagamento;
        }

        public PagamentoBuilderConcluido vencimento(LocalDate vencimento) {
            this.pagamento.vencimento = vencimento;
            return new PagamentoBuilderConcluido(pagamento);
        }
    }

    public static class PagamentoCartaoBuilder {
        private Pagamento pagamento;

        private PagamentoCartaoBuilder(Pagamento pagamento, CartaoCredito cartaoCredito) {
            this.pagamento = pagamento;
            this.pagamento.cartaoCredito = cartaoCredito;
        }

        public PagamentoCartaoValorBuilder valor(BigDecimal valor) {
            pagamento.valor = valor;
            return new PagamentoCartaoValorBuilder(pagamento);
        }
    }

    public static class PagamentoCartaoValorBuilder {
        private Pagamento pagamento;

        private PagamentoCartaoValorBuilder(Pagamento pagamento) {
            this.pagamento = pagamento;
        }

        public PagamentoBuilderConcluido parcelas(int parcelas) {
            this.pagamento.parcelas = parcelas;
            return new PagamentoBuilderConcluido(pagamento);
        }
    }

    public static class PagamentoBuilderConcluido {
        private Pagamento pagamento;

        public PagamentoBuilderConcluido(Pagamento pagamento) {
            this.pagamento = pagamento;
        }

        public Pagamento build() {
            return pagamento;
        }
    }
}

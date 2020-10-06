package com.totvs.guild_java.construcao_objetos.builder.argumentos_obrigatorios;

import java.time.Year;

public class Veiculo {
    private final String modelo;
    private Year anoFabricacao;
    private Year anoModelo;
    private String placa;
    private String fabricante;

    private Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public static VeiculoBuilder builder(String modelo) {
        return new VeiculoBuilder(modelo);
    }

    public String getModelo() {
        return modelo;
    }

    public Year getAnoFabricacao() {
        return anoFabricacao;
    }

    public Year getAnoModelo() {
        return anoModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getFabricante() {
        return fabricante;
    }

    public static final class VeiculoBuilder {
        private final String modelo;
        private Year anoFabricacao;
        private Year anoModelo;
        private String placa;
        private String fabricante;

        private VeiculoBuilder(String modelo) {
            this.modelo = modelo;
        }

        public VeiculoBuilder anoFabricacao(Year anoFabricacao) {
            this.anoFabricacao = anoFabricacao;
            return this;
        }

        public VeiculoBuilder anoModelo(Year anoModelo) {
            this.anoModelo = anoModelo;
            return this;
        }

        public VeiculoBuilder placa(String placa) {
            this.placa = placa;
            return this;
        }

        public VeiculoBuilder fabricante(String fabricante) {
            this.fabricante = fabricante;
            return this;
        }

        public Veiculo build() {
            Veiculo veiculo = new Veiculo(modelo);
            veiculo.anoModelo = this.anoModelo;
            veiculo.placa = this.placa;
            veiculo.anoFabricacao = this.anoFabricacao;
            veiculo.fabricante = this.fabricante;
            return veiculo;
        }
    }
}

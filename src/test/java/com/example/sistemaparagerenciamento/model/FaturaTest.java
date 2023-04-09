package com.example.sistemaparagerenciamento.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FaturaTest {

    private Fatura fatura;
    @BeforeEach
    void setUp() {
        this.fatura = new Fatura(1);
    }

    @Test
    void setValorPago() {
        this.fatura.setValorPago(10.0);
        assertEquals( 10.0, this.fatura.getValorPago(), "1° Teste setValor pago!");
        this.fatura.setValorPago(20.0);
        assertEquals(30.0,this.fatura.getValorPago(), "2° Teste setValor pago!");
    }

}
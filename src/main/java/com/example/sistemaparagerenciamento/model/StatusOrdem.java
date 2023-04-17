package com.example.sistemaparagerenciamento.model;

/**
 * classe enum para definir o estado da Ordem
 *
 * @author Emanuel Antonio Lima Pereira e Émerson Rodrigo Lima Pereira
 */
public enum StatusOrdem {

    /**
     * define se a ordem está no estado de pagamento, ou seja, é o estado em que os serviços foram terminados e não todos os pagamentos foram efetuados
     */
    PAGAMENTO,

    /**
     * define se a ordem está no estado de andamento, ou seja, é o estado em que os serviços não foram terminados
     */
    ANDAMENTO,

    /**
     * define se a ordem está no estado de fechada, ou seja, é o estado em que os serviços foram terminados e todos os pagamentos foram efetuados
     */
    FECHADA,

    /**
     * define se a ordem está no estado de cancelada, ou seja, é o estado em que a ordem não será realizada
     */
    CANCELADA

}
package com.example.sistemaparagerenciamento.model;

/**
 * classe enum para definir o estado da Ordem
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 */
public enum StatusOrdem {

    /**
     * define se a ordem est&aacute; no estado de pagamento, ou seja, &eacute; o estado em que os servi&ccedil;os foram terminados e n&atilde;o todos os pagamentos foram efetuados
     */
    PAGAMENTO,

    /**
     * define se a ordem est&aacute; no estado de andamento, ou seja, &eacute; o estado em que os servi&ccedil;os n&atilde;o foram terminados
     */
    ANDAMENTO,

    /**
     * define se a ordem est&aacute; no estado de fechada, ou seja, &eacute; o estado em que os servi&ccedil;os foram terminados e todos os pagamentos foram efetuados
     */
    FECHADA,

    /**
     * define se a ordem est&aacute; no estado de cancelada, ou seja, &eacute; o estado em que a ordem n&atilde;o ser&aacute; realizada
     */
    CANCELADA

}
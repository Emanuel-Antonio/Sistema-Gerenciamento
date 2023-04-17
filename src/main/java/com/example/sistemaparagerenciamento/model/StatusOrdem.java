package com.example.sistemaparagerenciamento.model;

/**
 * Classe enum para definir o estado da Ordem
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public enum StatusOrdem {

    /**
     * Define se a ordem est&aacute; no estado de pagamento, ou seja, &eacute; o estado em que os servi&ccedil;os foram terminados e n&atilde;o todos os pagamentos foram efetuados
     */
    PAGAMENTO,

    /**
     * Define se a ordem est&aacute; no estado de andamento, ou seja, &eacute; o estado em que os servi&ccedil;os n&atilde;o foram terminados
     */
    ANDAMENTO,

    /**
     * Define se a ordem est&aacute; no estado de fechada, ou seja, &eacute; o estado em que os servi&ccedil;os foram terminados e todos os pagamentos foram efetuados
     */
    FECHADA,

    /**
     * Define se a ordem est&aacute; no estado de cancelada, ou seja, &eacute; o estado em que a ordem n&atilde;o ser&aacute; realizada
     */
    CANCELADA

}
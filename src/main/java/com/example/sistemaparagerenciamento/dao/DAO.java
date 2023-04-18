package com.example.sistemaparagerenciamento.dao;

import com.example.sistemaparagerenciamento.dao.cliente.ClienteDAO;
import com.example.sistemaparagerenciamento.dao.cliente.ClienteListImpl;
import com.example.sistemaparagerenciamento.dao.ordem.OrdemDAO;
import com.example.sistemaparagerenciamento.dao.ordem.OrdemListImpl;
import com.example.sistemaparagerenciamento.dao.ordemcompra.OrdemCompraDAO;
import com.example.sistemaparagerenciamento.dao.ordemcompra.OrdemCompraListImpl;
import com.example.sistemaparagerenciamento.dao.pagamento.PagamentoDAO;
import com.example.sistemaparagerenciamento.dao.pagamento.PagamentoListImpl;
import com.example.sistemaparagerenciamento.dao.peca.PecaDAO;
import com.example.sistemaparagerenciamento.dao.peca.PecaListImpl;
import com.example.sistemaparagerenciamento.dao.servico.ServicoDAO;
import com.example.sistemaparagerenciamento.dao.servico.ServicoListImpl;
import com.example.sistemaparagerenciamento.dao.tecnico.TecnicoDAO;
import com.example.sistemaparagerenciamento.dao.tecnico.TecnicoListImpl;

/**
 * Classe DAO respons&aacute;vel por abstrair o banco de dados, em outras palavras, agrega todas as fun&ccedil;&otilde;es de persist&ecirc;ncia de dados
 *
 * @author Emanuel Antonio Lima Pereira e &Eacute;merson Rodrigo Lima Pereira
 * @version 1.0
 */
public class DAO {

        private static ClienteDAO clienteDAO;
        private static OrdemDAO ordemDAO;
        private static TecnicoDAO tecnicoDAO;
        private static ServicoDAO servicoDAO;
        private static PagamentoDAO pagamentoDAO;
        private static PecaDAO pecaDAO;
        private static OrdemCompraDAO ordemCompraDAO;

        /**
         * Padr&atilde;o singleton com o intuito de criar somente uma inst&acirc;ncia da implementa&ccedil;&atilde;o de ClienteDAO
         *
         * @return ClienteDAO
         */
        public static ClienteDAO getCliente() {
                if (clienteDAO == null) {
                    clienteDAO = new ClienteListImpl();
                }
                return clienteDAO;
        }

        /**
         * Padr&atilde;o singleton com o intuito de criar somente uma inst&acirc;ncia da implementa&ccedil;&atilde;o de OrdemDAO
         *
         * @return OrdemDAO
         */
        public static OrdemDAO getOrdem() {
            if (ordemDAO == null) {
                ordemDAO = new OrdemListImpl();
            }
            return ordemDAO;
        }

        /**
         * Padr&atilde;o singleton com o intuito de criar somente uma inst&acirc;ncia da implementa&ccedil;&atilde;o de TecnicoDAO
         *
         * @return TecnicoDAO
         */
        public static TecnicoDAO getTecnico() {
            if (tecnicoDAO == null) {
                tecnicoDAO = new TecnicoListImpl();
            }
            return tecnicoDAO;
        }

        /**
         * Padr&atilde;o singleton com o intuito de criar somente uma inst&acirc;ncia da implementa&ccedil;&atilde;o de ServicoDAO
         *
         * @return ServicoDAO
         */
        public static ServicoDAO getServico() {
            if (servicoDAO == null) {
                servicoDAO = new ServicoListImpl();
            }
            return servicoDAO;
        }

        /**
         * Padr&atilde;o singleton com o intuito de criar somente uma inst&acirc;ncia da implementa&ccedil;&atilde;o de PagamentoDAO
         *
         * @return PagamentoDAO
         */
        public static PagamentoDAO getPagamento() {
            if (pagamentoDAO == null) {
                pagamentoDAO = new PagamentoListImpl();
            }
            return pagamentoDAO;
        }

        /**
         * Padr&atilde;o singleton com o intuito de criar somente uma inst&acirc;ncia da implementa&ccedil;&atilde;o de PecaDAO
         *
         * @return PecaDAO
         */
        public static PecaDAO getPeca() {
            if (pecaDAO == null) {
                pecaDAO = new PecaListImpl();
            }
            return pecaDAO;
        }

        /**
         * Padr&atilde;o singleton com o intuito de criar somente uma inst&acirc;ncia da implementa&ccedil;&atilde;o de OrdemCompraDAO
         *
         * @return OrdemCompraDAO
         */
        public static OrdemCompraDAO getOrdemCompra() {
            if (ordemCompraDAO == null) {
                ordemCompraDAO = new OrdemCompraListImpl();
            }
            return ordemCompraDAO;
        }

}
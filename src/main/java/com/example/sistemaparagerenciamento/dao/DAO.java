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

public class DAO {

        private static ClienteDAO clienteDAO;

        private static OrdemDAO ordemDAO;

        private static TecnicoDAO tecnicoDAO;

        private static ServicoDAO servicoDAO;

        private static PagamentoDAO pagamentoDAO;

        private static PecaDAO pecaDAO;

        private static OrdemCompraDAO ordemCompraDAO;

        public static ClienteDAO getCliente() {
            if (clienteDAO == null) {
                clienteDAO = new ClienteListImpl();
            }
            return clienteDAO;
        }

        public static OrdemDAO getOrdem() {
            if (ordemDAO == null) {
                ordemDAO = new OrdemListImpl();
            }
            return ordemDAO;
        }

        public static TecnicoDAO getTecnico() {
            if (tecnicoDAO == null) {
                tecnicoDAO = new TecnicoListImpl();
            }
            return tecnicoDAO;
        }

        public static ServicoDAO getServico() {
            if (servicoDAO == null) {
                servicoDAO = new ServicoListImpl();
            }
            return servicoDAO;
        }

        public static PagamentoDAO getPagamento() {
            if (pagamentoDAO == null) {
                pagamentoDAO = new PagamentoListImpl();
            }
            return pagamentoDAO;
        }

        public static PecaDAO getPeca() {
            if (pecaDAO == null) {
                pecaDAO = new PecaListImpl();
            }
            return pecaDAO;
        }

        public static OrdemCompraDAO getOrdemCompra() {
            if (ordemCompraDAO == null) {
                ordemCompraDAO = new OrdemCompraListImpl();
            }
            return ordemCompraDAO;
        }

}

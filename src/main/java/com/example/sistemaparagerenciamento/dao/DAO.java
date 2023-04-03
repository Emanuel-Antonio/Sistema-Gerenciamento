package com.example.sistemaparagerenciamento.dao;

import com.example.sistemaparagerenciamento.dao.cliente.ClienteDAO;
import com.example.sistemaparagerenciamento.dao.cliente.ClienteFileImpl;
import com.example.sistemaparagerenciamento.dao.cliente.ClienteListImpl;
import com.example.sistemaparagerenciamento.dao.ordem.OrdemDAO;
import com.example.sistemaparagerenciamento.dao.ordem.OrdemFileImpl;
import com.example.sistemaparagerenciamento.dao.ordem.OrdemListImpl;
import com.example.sistemaparagerenciamento.dao.tecnico.TecnicoDAO;
import com.example.sistemaparagerenciamento.dao.tecnico.TecnicoFileImpl;
import com.example.sistemaparagerenciamento.dao.tecnico.TecnicoListImpl;

public class DAO {

        private static ClienteDAO clienteDAO;

        private static OrdemDAO ordemDAO;

        private static TecnicoDAO tecnicoDAO;

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

}

package com.example.sistemaparagerenciamento.dao;

import com.example.sistemaparagerenciamento.dao.cliente.ClienteDAO;
import com.example.sistemaparagerenciamento.dao.cliente.ClienteFileImpl;
import com.example.sistemaparagerenciamento.dao.controller.ControllerDAO;
import com.example.sistemaparagerenciamento.dao.controller.ControllerFileImpl;
import com.example.sistemaparagerenciamento.dao.ordem.OrdemDAO;
import com.example.sistemaparagerenciamento.dao.ordem.OrdemFileImpl;
import com.example.sistemaparagerenciamento.dao.tecnico.TecnicoDAO;
import com.example.sistemaparagerenciamento.dao.tecnico.TecnicoFileImpl;

public class DAO {

        private static ClienteDAO clienteDAO;

        private static ControllerDAO controllerDAO;

        private static OrdemDAO ordemDAO;

        private static TecnicoDAO tecnicoDAO;

        public static ClienteDAO getCliente() {
            if (clienteDAO == null) {
                clienteDAO = new ClienteFileImpl();
            }
            return clienteDAO;
        }

        public static ControllerDAO getController() {
            if (controllerDAO == null) {
                controllerDAO = new ControllerFileImpl();
            }
            return controllerDAO;
        }

        public static OrdemDAO getOrdem() {
            if (ordemDAO == null) {
                ordemDAO = new OrdemFileImpl();
            }
            return ordemDAO;
        }

        public static TecnicoDAO getTecnico() {
            if (tecnicoDAO == null) {
                tecnicoDAO = new TecnicoFileImpl();
            }
            return tecnicoDAO;
        }

}

package com.example.sistemaparagerenciamento.controller;

import com.example.sistemaparagerenciamento.dao.DAO;
import com.example.sistemaparagerenciamento.model.*;

public class Recepcao {

    private String email;
    private String senha;
    private String nome;

    public Ordem pegarOrdem(Tecnico tecnico) {
        if (DAO.getOrdem().getOrdens() != null) {
            for (int i = 0; i < DAO.getOrdem().getOrdens().size(); i++) {
                if (DAO.getOrdem().getOrdens().get(i).getTecnicoId() == -1) {
                    DAO.getTecnico().buscarPorId(tecnico.getTecnicoId()).setOrdem(DAO.getOrdem().getOrdens().get(i));
                    DAO.getOrdem().getOrdens().get(i).setTecnicoId(tecnico.getTecnicoId());
                    return DAO.getOrdem().getOrdens().get(i);
                }
            }
        }
        return null;
    }

    public Tecnico loginTecnico(String email, String senha) {
        for (int i = 0; i < DAO.getTecnico().getTecnicos().size(); i++) {
            if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email) && DAO.getTecnico().getTecnicos().get(i).getSenha().equals(senha)) {
                return DAO.getTecnico().getTecnicos().get(i);
            }
        }
        return null;
    }

    public Tecnico logoffTecnico() {
        return null;
    }

    public boolean cadastrarTecnico(String email, String nome, String senha) {
        for (int i = 0; i < DAO.getTecnico().getTecnicos().size(); i++) {
            if (DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email)) {
                return false;
            }
        }
        Tecnico tecnico = new Tecnico(email, nome, senha);
        if (DAO.getTecnico().getTecnicos().size() == 0) {
            tecnico.setAdm(true);
        }
        DAO.getTecnico().criar(tecnico);
        return true;
    }

    public boolean cadastrarCliente(String nome, String endereco, String telefone) {
        for (int i = 0; i < DAO.getCliente().getClientes().size(); i++) {
            if (DAO.getCliente().getClientes().get(i).getNome().equals(nome) && DAO.getCliente().getClientes().get(i).getEndereco().equals(endereco) && DAO.getCliente().getClientes().get(i).getTelefone().equals(telefone)) {
                return false;
            }
        }
        Cliente cliente = new Cliente(nome, endereco, telefone);
        DAO.getCliente().criar(cliente);
        return true;
    }

    public double mediaTempoDeEspera(Ordem ordem) {
        double tempoTotalEspera = 0.0;
        double qnt = 0.0;
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).getHorarioFechamento() != null && DAO.getServico().getServicos().get(i).getOrdemId() == ordem.getOrdemId())
                tempoTotalEspera += (DAO.getServico().getServicos().get(i).getHorarioFechamento().getTimeInMillis() - DAO.getServico().getServicos().get(i).getHorarioAbertura().getTimeInMillis());
                qnt++;
        }
        return (tempoTotalEspera/qnt)/(60.000*60);
    }

    public String custoPeca(Ordem ordem) {
        StringBuilder custoPeca = new StringBuilder();
        for(int i = 0; i < ordem.getServicos().size(); i++) {
            for(int ii = 0; ii < ordem.getServicos().get(i).getPecas().size(); ii++) {
                custoPeca.append("\n\n").append(ordem.getServicos().get(i).getPecas().get(ii));
            }
        }
        return custoPeca.toString();
    }

    public String relatorioGeral(Ordem ordem){
        String relatorio = "Desempenho do serviço:\n\n";
        relatorio = relatorio + "Tempo de espera: " + mediaTempoDeEspera(ordem) + "\n" + "Satisfação: " + ordem.getAvaliacaoFinal() + "\n" +
                "Custo pecas: " + custoPeca(ordem) + "\n" + "Situação do estoque: " + visualizarEstoque();
        return relatorio;
    }

    public String visualizarEstoque(){
        StringBuilder estoque = new StringBuilder("Estoque: ");
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            estoque.append("\n\n").append(DAO.getPeca().getPecas().get(i).toString());
        }
        return estoque.toString();
    }

}
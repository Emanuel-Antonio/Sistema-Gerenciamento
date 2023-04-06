package com.example.sistemaparagerenciamento.model;


import com.example.sistemaparagerenciamento.dao.DAO;

public class Recepcao {
    private String tipoPagamento;

    private Double valor;

    private String email;

    private String senha;

    private String nome;

    public boolean novoPagamento(Fatura fatura) {
        Pagamento pagamento = new Pagamento(this.tipoPagamento,this.valor,fatura);
        if(fatura.getValorTotal() >= (fatura.getValorPago() + pagamento.getValor())) {
            DAO.getPagamento().criar(pagamento);

            DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getFatura().setValorPago(pagamento.getValor());
            return true;
        }
        return false;
    }

    public Fatura gerarFatura(int ordemId){
        if(DAO.getOrdem().buscarPorId(ordemId).getFatura() == null && DAO.getOrdem().buscarPorId(ordemId).getServico() != null){
            Fatura fatura = new Fatura(ordemId);
            return fatura;
        }
        return null;
    }

    public Ordem pegarOrdem(Tecnico tecnico){
        if(DAO.getOrdem().getOrdens() != null){
            for(int i = 0; i < DAO.getOrdem().getOrdens().size();i++){
                if(DAO.getOrdem().getOrdens().get(i).getTecnicoId() == -1){
                    DAO.getTecnico().buscarPorId(tecnico.getTecnicoId()).setOrden(DAO.getOrdem().getOrdens().get(i));
                    DAO.getOrdem().getOrdens().get(i).setTecnicoId(tecnico.getTecnicoId());
                }
            }
        }
        return null;
    }

    public Tecnico loginTecnico(String email, String senha){
        for(int i = 0; i < DAO.getTecnico().getTecnicos().size();i++){
            if(DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email) && DAO.getTecnico().getTecnicos().get(i).getSenha().equals(senha)){
                return DAO.getTecnico().getTecnicos().get(i);
            }
        }
        return null;
    }

    public Tecnico logoffTecnico(){
        return null;
    }

    public boolean cadastrarTecnico(String email,String nome, String senha){
        for(int i = 0; i < DAO.getTecnico().getTecnicos().size();i++){
            if(DAO.getTecnico().getTecnicos().get(i).getEmail().equals(email)){
                return false;
            }
        }
        Tecnico tecnico = new Tecnico(email,nome,senha);
        if(DAO.getTecnico().getTecnicos() == null){
            tecnico.setAdm(true);
        }
        DAO.getTecnico().criar(tecnico);
        return true;
    }

    public boolean registrarCliente(String nome, String endereco, String telefone){
        for(int i = 0; i < DAO.getCliente().getClientes().size();i++){
            if(DAO.getCliente().getClientes().get(i).getNome().equals(nome) && DAO.getCliente().getClientes().get(i).getEndereco().equals(endereco) && DAO.getCliente().getClientes().get(i).getTelefone().equals(telefone)){
                return false;
            }
        }
        Cliente cliente = new Cliente(nome, endereco, telefone);
        DAO.getCliente().criar(cliente);
        return true;
    }

    public Boolean atualizarStatusPagamento(Ordem ordem){
        if(ordem.getStatus().equals(StatusOrdem.ABERTA) && ordem.getFatura().getValorPago() < ordem.getFatura().getValorTotal()) {
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.PAGAMENTO);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusFechada(Ordem ordem){
        if(ordem.getStatus().equals(StatusOrdem.PAGAMENTO) || ordem.getStatus().equals(StatusOrdem.ABERTA) && ordem.getFatura().getValorPago() == ordem.getFatura().getValorTotal()){
            DAO.getOrdem().buscarPorId((ordem.getOrdemId())).setStatus(StatusOrdem.FECHADA);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusCancelada(Ordem ordem){
        if(ordem.getStatus().equals(StatusOrdem.ABERTA)){
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.CANCELADA);

            return true;
        }
        return false;
    }

}

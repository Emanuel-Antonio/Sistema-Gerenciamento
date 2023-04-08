package com.example.sistemaparagerenciamento.model;


import com.example.sistemaparagerenciamento.dao.DAO;
import java.util.List;

public class Recepcao {
    private String tipoPagamento;

    private double valor;

    private String email;

    private String senha;

    private String nome;

    public boolean novoPagamento(Fatura fatura) {
        Pagamento pagamento = new Pagamento(this.tipoPagamento, this.valor, fatura);
        if (fatura.getValorTotal() >= (fatura.getValorPago() + pagamento.getValor())) {
            DAO.getPagamento().criar(pagamento);

            DAO.getPagamento().buscarPorId(pagamento.getPagamentoId()).getFatura().setValorPago(pagamento.getValor());
            return true;
        }
        return false;
    }

    public String gerarFatura(int ordemId) {
        if (DAO.getOrdem().buscarPorId(ordemId).getFatura() == null && DAO.getOrdem().buscarPorId(ordemId).getServicos() != null) {
            Fatura f = new Fatura(ordemId);
            DAO.getOrdem().buscarPorId(ordemId).setFatura(f);
            return f.toString();
        }
        return DAO.getOrdem().buscarPorId(ordemId).getFatura().toString();
    }

    public Ordem pegarOrdem(Tecnico tecnico) {
        if (DAO.getOrdem().getOrdens() != null) {
            for (int i = 0; i < DAO.getOrdem().getOrdens().size(); i++) {
                if (DAO.getOrdem().getOrdens().get(i).getTecnicoId() == -1) {
                    DAO.getTecnico().buscarPorId(tecnico.getTecnicoId()).setOrdem(DAO.getOrdem().getOrdens().get(i));
                    DAO.getOrdem().getOrdens().get(i).setTecnicoId(tecnico.getTecnicoId());
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
        if (DAO.getTecnico().getTecnicos() == null) {
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

    public Boolean atualizarStatusPagamento(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.ANDAMENTO) && ordem.getFatura().getValorPago() < ordem.getFatura().getValorTotal()) {
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.PAGAMENTO);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusFechada(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.PAGAMENTO) && ordem.getFatura().getValorPago() == ordem.getFatura().getValorTotal() || ordem.getStatus().equals(StatusOrdem.ANDAMENTO) && ordem.getFatura().getValorPago() == ordem.getFatura().getValorTotal()) {
            DAO.getOrdem().buscarPorId((ordem.getOrdemId())).setStatus(StatusOrdem.FECHADA);
            return true;
        }
        return false;
    }

    public Boolean atualizarStatusCancelada(Ordem ordem) {
        if (ordem.getStatus().equals(StatusOrdem.ANDAMENTO)) {
            DAO.getOrdem().buscarPorId(ordem.getOrdemId()).setStatus(StatusOrdem.CANCELADA);
            return true;
        }
        return false;
    }

    public boolean cadastrarServico(int ordemId, CategoriaServico categoria) {
        Servico servico = new Servico(ordemId, categoria);
        DAO.getServico().criar(servico);
        if(CategoriaServico.LIMPEZA.equals(categoria)){
            DAO.getServico().buscarPorId(servico.getServicoId()).setValor(70);
        }
        else if(CategoriaServico.FORMATACAO_INSTALACAO.equals(categoria)){
            DAO.getServico().buscarPorId(servico.getServicoId()).setValor(60);
        }
        DAO.getOrdem().buscarPorId(ordemId).getFatura().setValorTotal(DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().getValorTotal() + servico.getValor());
        List<Servico> servicos =  DAO.getOrdem().buscarPorId(ordemId).getServicos();
        servicos.add(servico);
        DAO.getOrdem().buscarPorId(ordemId).setServicos(servicos);
        return true;
    }

    public boolean removerServico(Servico servico) {
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).equals(servico)) {
                DAO.getServico().getServicos().remove(i);
                DAO.getOrdem().buscarPorId(servico.getOrdemId()).getServicos().remove(servico);
                DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().setValorTotal(DAO.getOrdem().buscarPorId(servico.getOrdemId()).getFatura().getValorTotal() - servico.getValor());
                return true;
            }
        }
        return false;
    }

    public boolean removerPecaDoServico(Servico servico, Peca peca) {
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).equals(servico)) {
                for (int j = 0; j < DAO.getServico().getServicos().get(i).getPecas().size(); j++) {
                    if (DAO.getServico().getServicos().get(i).getPecas().get(j).equals(peca)) {
                        DAO.getServico().getServicos().get(i).getPecas().remove(j);
                        DAO.getPeca().buscarPorNome(peca.getNome()).setQnt(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() + peca.getQnt());
                        DAO.getServico().getServicos().get(i).setValor(DAO.getServico().getServicos().get(i).getValor() - DAO.getServico().getServicos().get(i).getPecas().get(j).getValor());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean adicionarPecaAoServico(Servico servico, Peca peca) {
        for (int i = 0; i < DAO.getServico().getServicos().size(); i++) {
            if (DAO.getServico().getServicos().get(i).equals(servico) && DAO.getServico().getServicos().get(i).getCategoria().equals(CategoriaServico.MONTAGEM_INSTALACAO)) {
                List<Peca> p = DAO.getServico().getServicos().get(i).getPecas();
                p.add(peca);
                DAO.getPeca().buscarPorNome(peca.getNome()).setQnt(DAO.getPeca().buscarPorNome(peca.getNome()).getQnt() - peca.getQnt());
                DAO.getServico().getServicos().get(i).setPeca(p);

                if(peca.getNome().equals("RAM"))
                    DAO.getServico().getServicos().get(i).setValor(20);
                else if(peca.getNome().equals("Placa mãe") || peca.getNome().equals("placa de vídeo"))
                    DAO.getServico().getServicos().get(i).setValor(100);
                else if(peca.getNome().equals("fonte") || peca.getNome().equals("HD") || peca.getNome().equals("SSD"))
                    DAO.getServico().getServicos().get(i).setValor(30);

                DAO.getServico().getServicos().get(i).setValor(DAO.getServico().getServicos().get(i).getValor() + peca.getValor());
                return true;
            }
        }
        return false;
    }

    public String visualizarEstoque(){
        String estoque = "Estoque: ";
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            estoque = estoque + "\n\n" + DAO.getPeca().getPecas().get(i).toString();
        }
        return estoque;
    }

    public boolean cadastrarOrdem(int clienteId){
        for(int i = 0; i < DAO.getCliente().getClientes().size(); i++){
            if(DAO.getCliente().getClientes().get(i).getClienteId() == clienteId){
                Ordem ordem = new Ordem(null, clienteId);
                DAO.getOrdem().criar(ordem);
                List<Ordem> ordens = DAO.getCliente().getClientes().get(i).getOrdens();
                DAO.getCliente().getClientes().get(i).setOrdens(ordens);
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarOrdemCompra(int qnt, double valorUnitario, String nome){
        if(qnt <= 0 || valorUnitario <= 0) {
            return  false;
        }
        else {
            for (int i = 0; i < DAO.getPeca().getPecas().size(); i++) {
                if (DAO.getPeca().getPecas().get(i).getNome().equals(nome)) {
                    OrdemCompra ordemcompra = new OrdemCompra(qnt,valorUnitario,nome);
                    DAO.getOrdemCompra().criar(ordemcompra);
                }
            }
        }
        return false;
    }

    public String visualizarOrdensCompra(){
        String ordenscompra = "Ordens de compra: ";
        for(int i = 0; i < DAO.getOrdemCompra().getOrdensCompra().size(); i++){
            ordenscompra = ordenscompra + "\n\n" + DAO.getOrdemCompra().getOrdensCompra().get(i).toString();
        }
        return ordenscompra;
    }

    public void controlarCustoPeca(Peca peca, int qnt, double valor){
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            if(DAO.getPeca().getPecas().get(i).equals(peca)){
                double mediaValor = ((DAO.getPeca().getPecas().get(i).getValor() * DAO.getPeca().getPecas().get(i).getQnt()) + (valor * qnt))/(DAO.getPeca().getPecas().get(i).getQnt() + qnt);
                DAO.getPeca().getPecas().get(i).setValor(mediaValor);

                DAO.getPeca().getPecas().get(i).setQnt(DAO.getPeca().getPecas().get(i).getQnt() + qnt);
            }
        }
    }

    public Peca cadastrarPeca(String nome){
        for(int i = 0; i < DAO.getPeca().getPecas().size(); i++){
            if(DAO.getPeca().getPecas().get(i).getNome().equals(nome))
                return null;
        }
        Peca peca = new Peca(nome);
        DAO.getPeca().criar(peca);
        return peca;
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
        String custoPeca = "";
        for(int i = 0; i < ordem.getServicos().size(); i++) {
            for(int ii = 0; ii < ordem.getServicos().get(i).getPecas().size(); ii++) {
                custoPeca = custoPeca + "\n\n" + ordem.getServicos().get(i).getPecas().get(ii).getValor();
            }
        }
        return custoPeca;
    }

    public String relatorioGeral(Ordem ordem){
        String relatorio = "Desempenho do serviço:\n\n";
        relatorio = relatorio + "Tempo de espera: " + mediaTempoDeEspera(ordem) + "\n" + "Satisfação: " + ordem.getAvaliacaoFinal() + "\n" +
                "Custo pecas: " + custoPeca(ordem) + "\n" + "Situação do estoque: " + visualizarEstoque();
        return relatorio;
    }

}

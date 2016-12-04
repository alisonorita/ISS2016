package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.dao.relacionais.saida.DaoDevolucao;
import modelo.dao.relacionais.saida.DaoItemVenda;
import modelo.dao.relacionais.saida.DaoVenda;
import modelo.estruturais.Operacao;
import modelo.relacionais.saida.Devolucao;
import modelo.relacionais.saida.ItemVenda;
import modelo.relacionais.saida.Venda;
import visao.ajuda.ViewAjudaEfetuarDevolucao;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import visao.operacoes.ViewOperacaoEfetuarDevolucao;
import visao.pesquisa.ViewPesquisaVenda;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View de Efetuar Devolucao de uma Venda.
 * @author Hadyne
 */
public class ControllerViewOperacaoEfetuarDevolucao extends ControllerViewModal {
    private final ViewOperacaoEfetuarDevolucao viewOperacaoEfetuarDevolucao;
    private final DaoVenda                     daoVenda;
    private final DaoItemVenda                 daoItemVenda;
    private final DaoProduto                   daoProduto;
    private final DaoDevolucao                 daoDevolucao;
    private       List<ItemVenda>              itens;
   
    public ControllerViewOperacaoEfetuarDevolucao(ViewOperacaoEfetuarDevolucao oView) {
        super(oView);
        this.viewOperacaoEfetuarDevolucao = oView;
        this.daoVenda                     = new DaoVenda();
        this.daoItemVenda                 = new DaoItemVenda();
        this.daoProduto                   = new DaoProduto();
        this.daoDevolucao                 = new DaoDevolucao();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarDevolucao.getButtonSearchVenda())) {
            new ViewPesquisaVenda(this.viewOperacaoEfetuarDevolucao).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarDevolucao.getButtonConfirmar())) {
            if (this.checkParameters() == true) {
                Venda           oVenda     = this.viewOperacaoEfetuarDevolucao.getVenda();
                List<ItemVenda> oItens     = this.viewOperacaoEfetuarDevolucao.getItens();
                Devolucao       oDevolucao = new Devolucao(oVenda, null, "");
                for (int i = 0; i < oItens.size(); ++i) {
                    Produto oProduto = oItens.get(i).getProduto();
                            oProduto.setQuantidade(oProduto.getQuantidade() + oItens.get(i).getQuantidade());
                    this.daoProduto.update(oProduto);
                    this.daoItemVenda.remove(oItens.get(i).getId());
                }
                this.daoDevolucao.insert(oDevolucao);
                new DaoOperacao().insert(new Operacao("Devolucao = " + oDevolucao.getId(), new DaoAcao().get(32L), this.viewOperacaoEfetuarDevolucao.getUsuario()));
                new ViewMensagem(this.viewOperacaoEfetuarDevolucao, "Devolucao realizada com Sucesso!").setVisible(true);
                this.viewOperacaoEfetuarDevolucao.clear();
            }
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarDevolucao.getButtonCancelar())) {
            this.viewOperacaoEfetuarDevolucao.dispose();
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarDevolucao.getButtonAjuda())) {
            new ViewAjudaEfetuarDevolucao(this.viewOperacaoEfetuarDevolucao).setVisible(true);
        }
    }
    
    private boolean checkParameters() {
        if (this.viewOperacaoEfetuarDevolucao.getVenda() == null) {
            new ViewErro(this.viewOperacaoEfetuarDevolucao, "Selecione uma Venda!").setVisible(true);
            return false;
        }
        return true;
    }
}
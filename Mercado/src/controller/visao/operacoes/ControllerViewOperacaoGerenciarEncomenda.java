package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.dao.relacionais.saida.DaoVenda;
import modelo.estruturais.Operacao;
import modelo.relacionais.saida.ItemVenda;
import modelo.relacionais.saida.Venda;
import visao.ajuda.ViewAjudaGerenciarEncomenda;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import visao.operacoes.ViewOperacaoGerenciarEncomenda;
import visao.pesquisa.ViewPesquisaEncomenda;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View de Gerenciamento de Encomendas.
 * @author Marcos
 */
public class ControllerViewOperacaoGerenciarEncomenda extends ControllerViewModal {
    private final ViewOperacaoGerenciarEncomenda viewOperacaoGerenciarEncomenda;
    private final DaoVenda                       daoVenda;
    private       List<ItemVenda>                itens;
   
    public ControllerViewOperacaoGerenciarEncomenda(ViewOperacaoGerenciarEncomenda oView) {
        super(oView);
        this.viewOperacaoGerenciarEncomenda = oView;
        this.daoVenda                       = new DaoVenda();
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarEncomenda.getButtonSearchEncomenda())) {
            new ViewPesquisaEncomenda(this.viewOperacaoGerenciarEncomenda).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarEncomenda.getButtonOk())) {
            if (this.checkParameters() == true) {
                Venda oVenda = this.viewOperacaoGerenciarEncomenda.getVenda();
                      oVenda.setEntrega(true);
                this.daoVenda.update(oVenda);
                new DaoOperacao().insert(new Operacao("Venda = " + oVenda.getId(), new DaoAcao().get(33L), this.viewOperacaoGerenciarEncomenda.getUsuario()));
                new ViewMensagem(this.viewOperacaoGerenciarEncomenda, "Entrega realizada com Sucesso!").setVisible(true);
                this.viewOperacaoGerenciarEncomenda.clear();
            }
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarEncomenda.getButtonBack())) {
            this.viewOperacaoGerenciarEncomenda.dispose();
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarEncomenda.getButtonAjuda())) {
            new ViewAjudaGerenciarEncomenda(this.viewOperacaoGerenciarEncomenda).setVisible(true);
        }
    }
    
    private boolean checkParameters() {
        if (this.viewOperacaoGerenciarEncomenda.getVenda() == null) {
            new ViewErro(this.viewOperacaoGerenciarEncomenda, "Selecione uma Venda!").setVisible(true);
            return false;
        }
        return true;
    }
}
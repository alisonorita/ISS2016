package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import visao.mensagens.ViewMensagem;
import visao.operacoes.ViewOperacaoEfetuarDevolucao;
import visao.pesquisa.ViewPesquisaVenda;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View de Efetuar Devolucao de uma Venda.
 * @author Hadyne
 */
public class ControllerViewOperacaoEfetuarDevolucao extends ControllerViewModal {
    private final ViewOperacaoEfetuarDevolucao viewOperacaoEfetuarDevolucao;

   
    public ControllerViewOperacaoEfetuarDevolucao(ViewOperacaoEfetuarDevolucao oView) {
        super(oView);
        this.viewOperacaoEfetuarDevolucao = oView;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarDevolucao.getButtonSearchVenda())) {
            new ViewPesquisaVenda(this.viewOperacaoEfetuarDevolucao).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarDevolucao.getButtonConfirmar())) {
           
                new ViewMensagem(this.viewOperacaoEfetuarDevolucao, "Devolucao realizada com Sucesso!").setVisible(true);
                this.viewOperacaoEfetuarDevolucao.clear();
            }

    }
    

}
package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.cadastrais.Cliente;
import modelo.dao.cadastrais.DaoCliente;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.estruturais.Operacao;
import org.apache.commons.mail.EmailException;
import visao.ajuda.ViewAjudaRealizarNotificacoes;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import visao.operacoes.ViewOperacaoRealizarNotificacao;
import visao.pesquisa.ViewPesquisaCliente;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View para Realizar
 * Notificacoes aos Clientes.
 *
 * @author Felippe
 *
 */
public class ControllerViewOperacaoRealizarNotificacao extends ControllerViewModal {

    private final ViewOperacaoRealizarNotificacao viewOperacaoRealizarNotificacao;
    private final DaoCliente daoCliente;

    public ControllerViewOperacaoRealizarNotificacao(ViewOperacaoRealizarNotificacao oView) {
        super(oView);
        this.viewOperacaoRealizarNotificacao = oView;
        this.daoCliente = new DaoCliente();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoRealizarNotificacao.getButtonAddClientes())) {
            this.viewOperacaoRealizarNotificacao.addClientes();
        } else if (oActionEvent.getSource().equals(this.viewOperacaoRealizarNotificacao.getButtonAddCliente())) {
            new ViewPesquisaCliente(this.viewOperacaoRealizarNotificacao).setVisible(true);
        } else if (oActionEvent.getSource().equals(this.viewOperacaoRealizarNotificacao.getButtonRemoveCliente())) {
            int iIndex = this.viewOperacaoRealizarNotificacao.getTable().getSelectedRow();
            if (iIndex >= 0) {
                this.viewOperacaoRealizarNotificacao.removeCliente(iIndex);
            }
        } else if (oActionEvent.getSource().equals(this.viewOperacaoRealizarNotificacao.getButtonRemoveClientes())) {
            this.viewOperacaoRealizarNotificacao.removeClientes();
        } else if (oActionEvent.getSource().equals(this.viewOperacaoRealizarNotificacao.getButtonNotificar())) {
            if (this.checkParameters() == true) {
                int iIndex = this.viewOperacaoRealizarNotificacao.getTable().getSelectedRow();
                if (iIndex < 0) {
                    new ViewErro(this.viewOperacaoRealizarNotificacao, "Selecione um cliente").setVisible(true);
                } else {
                    Cliente cliente = this.viewOperacaoRealizarNotificacao.getClientes().get(iIndex);
                    try {
                        EnviadorEmail.enviarEmail(cliente.getEmail(), this.viewOperacaoRealizarNotificacao.getTextAreaMensagem().getText(), "Super Mercado Miguxo - Promoção");
                    } catch (EmailException ex) {
                        new ViewErro(this.viewOperacaoRealizarNotificacao, "Falha no envio do email").setVisible(true);
                    }
                    new DaoOperacao().insert(new Operacao("Clientes Notificados = " + this.viewOperacaoRealizarNotificacao.getClientes().size(), new DaoAcao().get(30L), this.viewOperacaoRealizarNotificacao.getUsuario()));
                    new ViewMensagem(this.viewOperacaoRealizarNotificacao, "Notificacao enviada com Sucesso!").setVisible(true);
                }

                this.viewOperacaoRealizarNotificacao.clear();
            }
        } else if (oActionEvent.getSource().equals(this.viewOperacaoRealizarNotificacao.getButtonCancelar())) {
            this.viewOperacaoRealizarNotificacao.dispose();
        } else if (oActionEvent.getSource().equals(this.viewOperacaoRealizarNotificacao.getButtonAjuda())) {
            new ViewAjudaRealizarNotificacoes(this.viewOperacaoRealizarNotificacao).setVisible(true);
        }
    }

    public boolean checkParameters() {
        if (this.viewOperacaoRealizarNotificacao.getClientes().isEmpty() == true) {
            new ViewErro(this.viewOperacaoRealizarNotificacao, "Nenhum Cliente Selecionado!").setVisible(true);
            return false;
        } else if (this.viewOperacaoRealizarNotificacao.getTextAreaMensagem().getText().trim().equals("") == true) {
            new ViewErro(this.viewOperacaoRealizarNotificacao, "Digite a Mensagem!").setVisible(true);
            return false;
        }
        return true;
    }
}

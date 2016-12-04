package controller.visao.estruturais;

import java.awt.event.ActionEvent;
import controller.visao.ControllerView;
import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import relatorios.Relatorio;
import relatorios.RelatorioDespesas;

import visao.cadastro.ViewCadastroClienteFisico;
import visao.cadastro.ViewCadastroClienteJuridico;

import relatorios.RelatorioProdutosEmEstoque;
import relatorios.RelatorioProdutosMaisVendidos;

import visao.cadastro.ViewCadastroProduto;
import visao.cadastro.ViewCadastroDespesa;

import visao.cadastro.ViewCadastroFornecedor;
import visao.cadastro.ViewCadastroMarca;
import visao.cadastro.ViewCadastroUsuario;
import visao.consulta.ViewConsultaCliente;
import visao.consulta.ViewConsultaFornecedor;
import visao.consulta.ViewConsultaMarca;

import visao.cadastro.ViewCadastroUsuario;

import visao.consulta.ViewConsultaProduto;
import visao.consulta.ViewConsultaDespesa;
import visao.consulta.ViewConsultaUsuario;
import visao.estruturais.ViewMenu;
import visao.mensagens.ViewErro;
import visao.operacoes.ViewOperacaoEfetuarDevolucao;
import visao.operacoes.ViewOperacaoEfetuarVenda;

import visao.operacoes.ViewOperacaoGerenciarProduto;
import visao.operacoes.ViewOperacaoRegistrarPedido;

import visao.operacoes.ViewOperacaoGerenciarUsuario;
import visao.sistema.ViewSistemaSobre;



/**
 * Classe responsavel por ser o <b>controlador</b> da ViewMenu.
 * @author  Marcos
 * @see     controller.visao.ControllerView
 */
public class ControllerViewMenu extends ControllerView {
    private final ViewMenu viewMenu;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewMenu(ViewMenu oView) {
        super(oView);
        this.viewMenu = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {

        
        if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroUsuario())) {
            new ViewCadastroUsuario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroDespesa())) {
            new ViewCadastroDespesa(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroClienteFisico())) {
            new ViewCadastroClienteFisico(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroClienteJuridico())) {
            new ViewCadastroClienteJuridico(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroFornecedor())) {
            new ViewCadastroFornecedor(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroMarca())) {
            new ViewCadastroMarca(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroProduto())) {
            new ViewCadastroProduto(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaUsuario())) {
            new ViewConsultaUsuario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaDespesa())) {
            new ViewConsultaDespesa(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaCliente())) {
            new ViewConsultaCliente(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaFornecedor())) {
            new ViewConsultaFornecedor(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaMarca())) {
            new ViewConsultaMarca(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaProduto())) {
            new ViewConsultaProduto(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemOperacoesRegistrarPedido())) {
            new ViewOperacaoRegistrarPedido(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemOperacoesEfetuarVenda())) {
            new ViewOperacaoEfetuarVenda(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemOperacoesEfetuarDevolucao())) {
            new ViewOperacaoEfetuarDevolucao(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemOperacoesGerenciarProduto())) {
            new ViewOperacaoGerenciarProduto(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemOperacoesGerenciarUsuario())) {
            new ViewOperacaoGerenciarUsuario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemRelatoriosProdutosMaisVendidos())) {
            try {
                Relatorio oRelatorio = new RelatorioProdutosMaisVendidos();
            } catch (JRException | IOException | SQLException ex) {
                new ViewErro(this.viewMenu, "Erro na Geracao do Relatorio!").setVisible(true);
            } 
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemRelatoriosProdutosEstoque())) {
            try {
                Relatorio oRelatorio = new RelatorioProdutosEmEstoque();
            } catch (JRException | IOException | SQLException ex) {
                new ViewErro(this.viewMenu, "Erro na Geracao do Relatorio!").setVisible(true);
            } 
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemRelatoriosDespesa())) {
            try {
                Relatorio oRelatorio = new RelatorioDespesas();
            } catch (JRException | IOException | SQLException ex) {
                new ViewErro(this.viewMenu, "Erro na Geracao do Relatorio!").setVisible(true);
            } 
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemSistemaSobre())) {
            new ViewSistemaSobre(this.viewMenu).setVisible(true);
        }
        
    }
}


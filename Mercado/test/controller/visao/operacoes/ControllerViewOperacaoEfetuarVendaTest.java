package controller.visao.operacoes;

import java.util.ArrayList;
import java.util.List;
import modelo.cadastrais.Cliente;
import modelo.dao.cadastrais.DaoCliente;
import modelo.dao.cadastrais.DaoProduto;
import modelo.relacionais.saida.ItemVenda;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import visao.operacoes.ViewOperacaoEfetuarVenda;

/**
 * @author Hadyne
 */
public class ControllerViewOperacaoEfetuarVendaTest {
    
    public ControllerViewOperacaoEfetuarVendaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCheckParameters() {
        assertFalse(this.testeErro1());
        assertFalse(this.testeErro2());
        assertFalse(this.testeErro3());
        assertTrue(this.testeSucesso());
    }
    
    private boolean testeErro1() {
        Cliente         cliente = null;
        List<ItemVenda> itens   = new ArrayList<>();
        ViewOperacaoEfetuarVenda oView                 = new ViewOperacaoEfetuarVenda(null);
        ControllerViewOperacaoEfetuarVenda oController = new ControllerViewOperacaoEfetuarVenda(oView);
        return oController.checkParameters(cliente, itens);
    }
    
    private boolean testeErro2() {
        Cliente         cliente = new DaoCliente().get(1L);
        List<ItemVenda> itens   = new ArrayList<>();
        ViewOperacaoEfetuarVenda oView                 = new ViewOperacaoEfetuarVenda(null);
        ControllerViewOperacaoEfetuarVenda oController = new ControllerViewOperacaoEfetuarVenda(oView);
        return oController.checkParameters(cliente, itens);
    }
    
    private boolean testeErro3() {
        Cliente         cliente = null;
        ItemVenda       item    = new ItemVenda(null, new DaoProduto().get(1L), 1, 3.4f);
        List<ItemVenda> itens   = new ArrayList<>();
                        itens.add(item);
        ViewOperacaoEfetuarVenda oView                 = new ViewOperacaoEfetuarVenda(null);
        ControllerViewOperacaoEfetuarVenda oController = new ControllerViewOperacaoEfetuarVenda(oView);
        return oController.checkParameters(cliente, itens);
    }
    
    
    private boolean testeSucesso() {
        Cliente         cliente = new DaoCliente().get(1L);
        ItemVenda       item    = new ItemVenda(null, new DaoProduto().get(1L), 1, 3.4f);
        List<ItemVenda> itens   = new ArrayList<>();
                        itens.add(item);
        ViewOperacaoEfetuarVenda oView                 = new ViewOperacaoEfetuarVenda(null);
        ControllerViewOperacaoEfetuarVenda oController = new ControllerViewOperacaoEfetuarVenda(oView);
        return oController.checkParameters(cliente, itens);
    }
}
package controller.visao.operacoes;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.cadastrais.DaoProduto;
import modelo.dao.gerenciais.DaoFornecedor;
import modelo.gerenciais.Fornecedor;
import modelo.relacionais.entrada.ItemPedido;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import visao.operacoes.ViewOperacaoRegistrarPedido;

/**
 *
 * @author Marcos
 */
public class ControllerViewOperacaoRegistrarPedidoTest {
    
    public ControllerViewOperacaoRegistrarPedidoTest() {
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
        assertFalse(this.testErro1());
        assertFalse(this.testErro2());
        assertFalse(this.testErro3());
        assertTrue(this.testSucesso());
    }
    
    private boolean testErro1() {
        Fornecedor                            oFornecedor = null;
        ItemPedido                            oItemPedido = new ItemPedido(null, new DaoProduto().get(1L), 2, 3.0f);
        List<ItemPedido>                      oItens      = new ArrayList<>();
                                              oItens.add(oItemPedido);
        String                                sData       = "21/01/2017";
        ViewOperacaoRegistrarPedido           oView       = new ViewOperacaoRegistrarPedido(null);
        ControllerViewOperacaoRegistrarPedido oController = new ControllerViewOperacaoRegistrarPedido(oView);
        return oController.checkParameters(oFornecedor, oItens, sData);
    }
    
    private boolean testErro2() {
        Fornecedor                            oFornecedor = new DaoFornecedor().get(1L);
        List<ItemPedido>                      oItens      = new ArrayList<>();
        String                                sData       = "21/01/2017";
        ViewOperacaoRegistrarPedido           oView       = new ViewOperacaoRegistrarPedido(null);
        ControllerViewOperacaoRegistrarPedido oController = new ControllerViewOperacaoRegistrarPedido(oView);
        return oController.checkParameters(oFornecedor, oItens, sData);
    }
    
    private boolean testErro3() {
        Fornecedor                            oFornecedor = new DaoFornecedor().get(1L);
        ItemPedido                            oItemPedido = new ItemPedido(null, new DaoProduto().get(1L), 2, 3.0f);
        List<ItemPedido>                      oItens      = new ArrayList<>();
                                              oItens.add(oItemPedido);
        String                                sData       = "";
        ViewOperacaoRegistrarPedido           oView       = new ViewOperacaoRegistrarPedido(null);
        ControllerViewOperacaoRegistrarPedido oController = new ControllerViewOperacaoRegistrarPedido(oView);
        return oController.checkParameters(oFornecedor, oItens, sData);
    }
    
    private boolean testSucesso() {
        Fornecedor                            oFornecedor = new DaoFornecedor().get(1L);
        ItemPedido                            oItemPedido = new ItemPedido(null, new DaoProduto().get(1L), 2, 3.0f);
        List<ItemPedido>                      oItens      = new ArrayList<>();
                                              oItens.add(oItemPedido);
        String                                sData       = "21/01/2017";
        ViewOperacaoRegistrarPedido           oView       = new ViewOperacaoRegistrarPedido(null);
        ControllerViewOperacaoRegistrarPedido oController = new ControllerViewOperacaoRegistrarPedido(oView);
        return oController.checkParameters(oFornecedor, oItens, sData);
    }
}
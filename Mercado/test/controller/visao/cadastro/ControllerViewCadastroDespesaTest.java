package controller.visao.cadastro;

import visao.cadastro.ViewCadastroDespesa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerViewCadastroDespesaTest {
    
    public ControllerViewCadastroDespesaTest() {
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
    public void testCheckParameters1() {
        ViewCadastroDespesa oView = new ViewCadastroDespesa(null);               
        ControllerViewCadastroDespesa oController = new ControllerViewCadastroDespesa(oView);
        assertFalse(oController.checkParameters("", ""));
    }
    
    @Test
    public void testCheckParameters2() {
        ViewCadastroDespesa oView = new ViewCadastroDespesa(null);               
        ControllerViewCadastroDespesa oController = new ControllerViewCadastroDespesa(oView);
        assertFalse(oController.checkParameters("Descrição Teste", ""));
    }
    
    @Test
    public void testCheckParameters3() {
        ViewCadastroDespesa oView = new ViewCadastroDespesa(null);               
        ControllerViewCadastroDespesa oController = new ControllerViewCadastroDespesa(oView);
        assertTrue(oController.checkParameters("Descrição Teste", "10.00"));
    }    
   
}

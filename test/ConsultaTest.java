/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.LoginDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import entidade.Login;
import entidade.Usuario;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class ConsultaTest {
    
    public ConsultaTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test()
    public void testeConsultaUsuarioPorID(){
        UsuarioDAO ud = new UsuarioDAO();
        assertEquals(1, ud.consultarPorId("1").getId());
    }
    
    @Test()
    public void testeConsultaLoginPorID(){
        LoginDAO ud = new LoginDAO();
        assertEquals(1, ud.consultarPorId(1).getId());
    }
    
    @Test()
    public void testeConsultaUsuarioPorLogin(){
        UsuarioDAO ud = new UsuarioDAO();
        Login l = new Login();
        l.setId(1);
        assertNotNull(ud.consultaPorLogin(l).getId());
    }
    
    @Test()
    public void testeConsultaUsuarioPorCriterioTabela(){
        UsuarioDAO ud = new UsuarioDAO();
        JTable jt = new JTable();
        assertEquals(true, ud.popularTabela(jt, ""));
    }
    
    @Test()
    public void testeConsultaProdutoCriterioTabela(){
        ProdutoDAO pd = new ProdutoDAO();
        JTable jt = new JTable();
        assertEquals(true, pd.popularTabela(jt, ""));
    }
    
    
}

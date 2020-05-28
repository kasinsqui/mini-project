/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.LoginDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import entidade.Login;
import entidade.Produto;
import entidade.Usuario;
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
public class SaveTest {

    @Test
    public void testeSalvaLogin() throws Exception {
        Login l = new Login();
        l.setNome("testeSalvaLogin");
        l.setSenha("testeSalvaLogin");
        LoginDAO ld = new LoginDAO();
        System.out.println("Primeiro teste");
        assertNotEquals(0, ld.salva(l));
    }
    @Test
    public void testeSalvaUsuario() throws Exception {
        Usuario u = new Usuario();
        u.setNome("testeSalvaUsuario : mrTeste");
        u.setCargo('A');
        u.setLoginId(1);
        UsuarioDAO ud = new UsuarioDAO();
        System.out.println("Primeiro teste");
        assertEquals(true, ud.salva(u));
    }
    @Test
    public void testeSalvaProduto() throws Exception {
        Produto p = new Produto();
        p.setNome("testeSalvaProduto : mrTestersons");
        p.setDescricao("este produto esta sendo testado"); 
        ProdutoDAO pd = new ProdutoDAO();
        System.out.println("Primeiro teste");
        assertEquals(true, pd.salva(p));
    }

    public SaveTest() {
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
}

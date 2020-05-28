
import apoio.ConexaoBD;
import java.sql.Connection;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Augusto
 */
public class ConexaoBDTest {

    Connection conexao;

    public ConexaoBDTest() {

    }

    @Before
    public void SetUp() {
        conexao = null;
    }

    // Augusto Fritz
    @Test
    public void testeConexaoBanco() {
        assertNotEquals(conexao, ConexaoBD.getInstance().getConnection());
    }
}

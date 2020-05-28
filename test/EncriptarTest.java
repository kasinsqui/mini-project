
import apoio.Encriptar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class EncriptarTest {

    // Augusto Fritz
    @Test
    public void testeMetodoMd5Encriptar() {
        String stringTeste = "admin";
        assertNotNull(Encriptar.md5(stringTeste));
    }

    // Augusto Fritz
    @Test
    public void testeValorMd5Ecriptar() {
        String stringTeste = "admin";
//        String stringTeste = "admi";
        assertEquals("21232f297a57a5a743894a0e4a801fc3", Encriptar.md5(stringTeste));
    }
}

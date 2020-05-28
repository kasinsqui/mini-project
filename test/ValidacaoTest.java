
import apoio.Validacao;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fritzzin
 */
public class ValidacaoTest {

    public ValidacaoTest() {

    }

    // Augusto Fritz
    // Fazer um com pontuacao e outro sem?
    @Test
    public void testeCPF() {
//        String cpf = "033.711.300-96";
        String cpf = "03371130096";
        assertEquals(true, Validacao.validarCPF(cpf));
    }
    
    // Augusto Fritz
    @Test
    public void testeCNPJ() {
        String cnpj = "70.868.448/0001-07";
//        String cnpj = "70868448000107";
        assertEquals(true, Validacao.validarCNPJ(cnpj));
    }
    @Test
    public void testeTemNumero(){
        String numeros = "123456789";
        assertEquals(true,Validacao.temNumeros(numeros));
    }
    @Test
    public void testeLetras(){
        String letras = "testeNervoso1";
        assertEquals(true,Validacao.temLetras(letras));
    }
}

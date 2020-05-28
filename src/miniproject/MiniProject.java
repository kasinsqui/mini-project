package miniproject;

import apoio.ConexaoBD;
import telas.DlgLogin;

/**
 *
 * @author fritzzin
 */
public class MiniProject {

    public static void main(String[] args) {
        ConexaoBD banco = new ConexaoBD();
        banco.getConnection();
        
        DlgLogin dlglogin = new DlgLogin(null, true);
        dlglogin.setVisible(true);
    }
}

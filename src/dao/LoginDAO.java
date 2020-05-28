package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Login;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fritzzin
 */
public class LoginDAO implements IDAO_T {

    ResultSet resultadoQ = null;
    Login login;

    @Override
    public String salvar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Login consultarLogin(String usuario, String senha) {
        Login usuarioLogando = new Login();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT   * \n"
                    + "FROM     login \n"
                    + "WHERE    login = '" + usuario + "' \n"
                    + "AND      senha = '" + senha + "' \n";

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                usuarioLogando.setId(resultadoQ.getInt("id"));
                usuarioLogando.setNome(resultadoQ.getString("login"));
                usuarioLogando.setSenha(resultadoQ.getString("senha"));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioLogando;
    }

    @Override
    public Object consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Login consultarPorLogin(Login login) {
        Login resultado = new Login();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT   * \n"
                    + "FROM     login \n"
                    + "WHERE    login = '" + login.getNome() + "' \n"
                    + "AND      senha = '" + login.getSenha() + "' \n";
            System.out.println(sql);

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                resultado.setId(resultadoQ.getInt("id"));
                resultado.setNome(login.getNome());
                resultado.setSenha(login.getSenha());
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Login consultarPorId(int id) {
        Login resultado = new Login();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT   * \n"
                    + "FROM     login \n"
                    + "WHERE    id = '" + id + "' \n";

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                resultado.setId(resultadoQ.getInt("id"));
                resultado.setNome(resultadoQ.getString("login"));
                resultado.setSenha(resultadoQ.getString("senha"));
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean realizarLogin(Login login) {
        boolean sucesso = false;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT   * \n"
                    + "FROM     login \n"
                    + "WHERE    login = '" + login.getNome() + "' \n"
                    + "AND      senha = '" + login.getSenha() + "' \n";

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                sucesso = true;
            } else {
                sucesso = false;
                JOptionPane.showMessageDialog(null, "Login não existente!");
            }
            return sucesso;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Login l) {
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE login\n"
                    + "SET login = '"+l.getNome()+"',\n"
                    + "    senha = '"+l.getSenha()+"'\n"
                    + "WHERE\n"
                    + "   id = "+l.getId();

            int result = st.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int salva(Login o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            st.execute("Insert into login (login,senha)"
                    + "values('" + o.getNome() + "', '" + o.getSenha() + "')");

            String sql = ""
                    + "SELECT   max(id) \n"
                    + "FROM     login \n";
            System.out.println(sql);

            resultadoQ = st.executeQuery(sql);
            int lastId = 0;

            if (resultadoQ.next()) {
                lastId = resultadoQ.getInt("max");
            }

            return lastId;
        } catch (Exception e) {
            System.out.println("Erro salvar pessoa = " + e);
            e.printStackTrace();
            return 0;
        }
    }

    public boolean exclui(Login o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            st.execute("delete from login where id = " + o.getId());

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar pessoa = " + e);
            e.printStackTrace();
            return false;
        }
    }
}

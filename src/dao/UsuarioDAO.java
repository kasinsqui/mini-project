/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Login;
import entidade.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author fritzzin
 */
public class UsuarioDAO implements IDAO_T {

    private ResultSet resultadoQ = null;

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

    public Usuario consultaPorLogin(Login login) {
        Usuario usuario = new Usuario();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT   * \n"
                    + "FROM     usuario \n "
                    + "WHERE    login_id = '" + login.getId() + "' \n";

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                usuario.setId(resultadoQ.getInt("id"));
                usuario.setNome(resultadoQ.getString("nome"));
                usuario.setCargo(resultadoQ.getString("cargo").charAt(0));
                usuario.setLoginId(login.getId());

                return usuario;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario consultarPorId(String id) {
        Usuario resultado = new Usuario();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT   * \n"
                    + "FROM     usuario \n"
                    + "WHERE    id = '" + id + "' \n";

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                resultado.setId(resultadoQ.getInt("id"));
                resultado.setNome(resultadoQ.getString("nome"));
                resultado.setCargo(resultadoQ.getString("cargo").charAt(0));
                resultado.setLoginId(resultadoQ.getInt("login_id"));
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean salva(Usuario u) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            st.execute("Insert into usuario (nome,cargo,login_id)"
                    + "values('" + u.getNome() + "', '" + u.getCargo() + "', " + u.getLoginId() + ")");

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar pessoa = " + e);
            e.printStackTrace();
            return false;
        }
    }

    public boolean exclui(Usuario u) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            st.execute("delete from usuario where id = " + u.getId());
            Login l = new Login();
            l.setId(u.getLoginId());
            new LoginDAO().exclui(l);

            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar pessoa = " + e);
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Usuario l) {

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario\n"
                    + "SET nome = '" + l.getNome() + "',\n"
                    + "    cargo = '" + l.getCargo() + "'\n"
                    + "WHERE\n"
                    + "   id = " + l.getId();

            int result = st.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "ID";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Cargo";
        cabecalho[3] = "idLogin";
        cabecalho[4] = "Login";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) FROM usuario WHERE nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][cabecalho.length];

        } catch (Exception e) {
            System.out.println("Erro ao consultar pessoa: " + e);
            System.out.println(""
                    + "SELECT count(*) FROM usuario WHERE nome ILIKE '%" + criterio + "%'");
            return false;
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * FROM usuario WHERE nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("cargo");
                Login l = new Login();
                l = new LoginDAO().consultarPorId(resultadoQ.getInt("login_id"));
                dadosTabela[lin][4] = l.getNome();
                dadosTabela[lin][3] = l.getId();

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
            System.out.println(""
                    + "SELECT * FROM usuario WHERE nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");
            return false;
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
        return true;
    }

}

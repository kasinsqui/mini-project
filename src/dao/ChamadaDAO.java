/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO_T;
import entidade.Chamada;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author patun
 */
public class ChamadaDAO implements IDAO_T<Chamada>{
    ResultSet resultadoQ = null;
    @Override
    public String salvar(Chamada o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into os values(default,"+ o.getProduto_id()+","+o.getUser_id()+","+o.getUser_id1()+","+o.getPrioridade_id()+",'"+o.getTitulo()+"','"+o.getDescricao()+"')";
             System.out.println("sql: " + sql);

            int resultado = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro salvar chamada = " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Chamada o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Chamada> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Chamada> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chamada consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

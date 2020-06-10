/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author patun
 */
public class Chamada {
    private int id;
    private int produto_id;
    private int user_id;
    private int user_id1;
    private int prioridade_id;
    private String titulo;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id1() {
        return user_id1;
    }

    public void setUser_id1(int user_id1) {
        this.user_id1 = user_id1;
    }

    public int getPrioridade_id() {
        return prioridade_id;
    }

    public void setPrioridade_id(int prioridade_id) {
        this.prioridade_id = prioridade_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

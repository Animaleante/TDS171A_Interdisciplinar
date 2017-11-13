package com.tds171a.soboru.vos;

/**
 * Classe de ValueObject do Categoria
 * @author Diogo
 *
 */
public class Categoria {

    /**
     * Par�metro id do Categoria
     */
    private int id;

    /**
     * Par�metro nome do Categoria
     */
    private String nome;

    /**
     * Construtor da classe de Categoria
     */
    public Categoria() {

        id = -1;
        nome = "";
    }

    /**
     * Construtor da classe de Categoria que recebe o id e o nome
     * @param id
     * @param nome
     */
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * @return o id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id o id para setar
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return o nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome o nome para setar
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}

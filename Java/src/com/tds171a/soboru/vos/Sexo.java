package com.tds171a.soboru.vos;

/**
 * Classe de ValueObject do Sexo
 * @author Diogo
 *
 */
public class Sexo {

    /**
     * Par�metro id do Sexo
     */
    private int id;

    /**
     * Par�metro nome do Sexo
     */
    private String nome;

    /**
     * Construtor da classe de Sexo
     */
    public Sexo() {

        id = -1;
        nome = "";
    }

    /**
     * Construtor da classe de Sexo que recebe o nome
     * @param nome
     */


    public Sexo(String nome) {
        this.nome = nome;
    }

    /**
     * Construtor da classe de Sexo que recebe o id e o nome
     * @param id
     * @param nome
     */
    public Sexo(int id, String nome) {
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

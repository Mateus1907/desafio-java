package com.desafio.api.model;

/**
 * Classe Aluno — representa o modelo de domínio.
 *
 * Conceitos demonstrados:
 * - CLASSE: molde que define atributos e comportamentos de um Aluno
 * - ENCAPSULAMENTO: atributos privados acessados via getters/setters
 * - CONSTRUTOR: inicializa o estado do objeto ao ser instanciado
 * - ESCOPO: atributos são variáveis de instância (escopo de classe)
 */
public class Aluno {

    // Variáveis de instância (equivalente a "globais" dentro da classe)
    private String nome;
    private double nota1;
    private double nota2;

    /**
     * Construtor — chamado ao usar "new Aluno(...)"
     * Inicializa o estado do objeto Aluno.
     *
     * @param nome  nome do aluno
     * @param nota1 primeira nota
     * @param nota2 segunda nota
     */
    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    /**
     * Calcula a média do aluno.
     *
     * Assinatura do método: calcularMedia()
     * Retorno: double — a média aritmética das duas notas
     *
     * @return média entre nota1 e nota2
     */
    public double calcularMedia() {
        // 'media' é uma variável LOCAL — existe apenas dentro deste método
        double media = (this.nota1 + this.nota2) / 2;
        return media;
    }

    // Getters e Setters — Encapsulamento
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
}

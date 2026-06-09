package com.desafio.api.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO (Data Transfer Object) que representa os dados recebidos
 * no endpoint de cálculo de média.
 *
 * Conceito aplicado: Encapsulamento — os dados são agrupados
 * em um objeto com validações, sem expor detalhes internos.
 */
public class AlunoRequestDTO {

    @NotBlank(message = "O nome do aluno é obrigatório")
    private String nome;

    @NotNull(message = "A nota 1 é obrigatória")
    @DecimalMin(value = "0.0", message = "A nota 1 deve ser maior ou igual a 0")
    @DecimalMax(value = "10.0", message = "A nota 1 deve ser menor ou igual a 10")
    private Double nota1;

    @NotNull(message = "A nota 2 é obrigatória")
    @DecimalMin(value = "0.0", message = "A nota 2 deve ser maior ou igual a 0")
    @DecimalMax(value = "10.0", message = "A nota 2 deve ser menor ou igual a 10")
    private Double nota2;

    // Construtor padrão (necessário para desserialização JSON)
    public AlunoRequestDTO() {}

    // Construtor completo
    public AlunoRequestDTO(String nome, Double nota1, Double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // Getters e Setters — parte do Encapsulamento
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }
}

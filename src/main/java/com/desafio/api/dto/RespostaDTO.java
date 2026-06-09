package com.desafio.api.dto;

/**
 * DTO de resposta padrão da API.
 * Encapsula a mensagem de retorno para todos os endpoints.
 */
public class RespostaDTO {

    private String mensagem;

    // Construtor padrão
    public RespostaDTO() {}

    // Construtor com mensagem
    public RespostaDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

package com.desafio.api.service;

import com.desafio.api.dto.AlunoRequestDTO;

/**
 * INTERFACE — define o CONTRATO do serviço de cálculo de média.
 *
 * Conceito demonstrado:
 * - INTERFACE: define O QUE deve ser feito, sem implementar o COMO.
 * - Qualquer classe que implemente esta interface DEVE fornecer
 *   a implementação dos métodos aqui declarados.
 */
public interface MediaService {

    /**
     * Calcula a média de um aluno e retorna a mensagem de resultado.
     *
     * Assinatura: calcularMedia(AlunoRequestDTO)
     * Retorno: String — mensagem de aprovação ou reprovação
     *
     * @param request DTO com nome e notas do aluno
     * @return mensagem com o resultado
     */
    String calcularMedia(AlunoRequestDTO request);
}

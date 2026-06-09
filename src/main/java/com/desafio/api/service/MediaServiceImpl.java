package com.desafio.api.service;

import com.desafio.api.dto.AlunoRequestDTO;
import com.desafio.api.model.Aluno;
import org.springframework.stereotype.Service;

/**
 * Implementação concreta de MediaService.
 *
 * Conceitos demonstrados:
 * - HERANÇA / IMPLEMENTAÇÃO: esta classe implementa o contrato da interface MediaService
 * - OBJETO: instanciamos um objeto Aluno a partir da classe Aluno (molde)
 * - ENCAPSULAMENTO: a lógica de negócio está encapsulada aqui, isolada do Controller
 */
@Service
public class MediaServiceImpl implements MediaService {

    // Nota de corte — variável de classe (escopo de classe, equivalente a "global")
    private static final double NOTA_CORTE = 5.0;

    /**
     * Implementação do contrato definido em MediaService.
     *
     * Assinatura: calcularMedia(AlunoRequestDTO)
     * Retorno: String
     *
     * @param request DTO com os dados do aluno
     * @return mensagem de aprovação ou reprovação
     */
    @Override
    public String calcularMedia(AlunoRequestDTO request) {
        // Criando um OBJETO da classe Aluno (instância)
        Aluno aluno = new Aluno(request.getNome(), request.getNota1(), request.getNota2());

        // Variável local — existe apenas no escopo deste método
        double media = aluno.calcularMedia();
        String nome = aluno.getNome();

        // Regra de negócio conforme especificado no desafio
        if (media > NOTA_CORTE) {
            return String.format("Parabéns %s, você foi aprovado.", nome);
        } else if (media < NOTA_CORTE) {
            return String.format("%s, você foi reprovado.", nome);
        } else {
            // media == NOTA_CORTE (exatamente 5.0)
            return String.format("%s, você não atingiu a nota de corte e foi reprovado.", nome);
        }
    }
}

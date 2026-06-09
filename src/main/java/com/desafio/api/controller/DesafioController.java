package com.desafio.api.controller;

import com.desafio.api.dto.AlunoRequestDTO;
import com.desafio.api.dto.RespostaDTO;
import com.desafio.api.service.MediaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controller REST — ponto de entrada dos endpoints HTTP.
 *
 * Conceitos demonstrados:
 * - HERANÇA/INJEÇÃO: MediaService é injetado via construtor (boas práticas)
 * - ENCAPSULAMENTO: detalhes de implementação ficam no Service, Controller apenas delega
 * - OBJETO: ResponseEntity é um objeto que encapsula resposta HTTP
 */
@RestController
@RequestMapping("/api")
public class DesafioController {

    // Dependência injetada pelo Spring — favorece o uso da INTERFACE, não da implementação
    private final MediaService mediaService;

    /**
     * Construtor — Spring injeta automaticamente a implementação de MediaService.
     * Demonstra: injeção de dependência e uso de interface como tipo.
     *
     * @param mediaService implementação do serviço de média
     */
    public DesafioController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    /**
     * Endpoint 1 — Calcular média do aluno.
     *
     * POST /api/media
     *
     * Assinatura do método: calcularMedia(AlunoRequestDTO)
     * Retorno: ResponseEntity<RespostaDTO>
     *
     * Exemplo de corpo da requisição:
     * {
     *   "nome": "João",
     *   "nota1": 7.0,
     *   "nota2": 8.0
     * }
     *
     * @param request JSON com nome, nota1 e nota2
     * @return mensagem de aprovação ou reprovação
     */
    @PostMapping("/media")
    public ResponseEntity<RespostaDTO> calcularMedia(@Valid @RequestBody AlunoRequestDTO request) {
        // Variável local — existe apenas no escopo deste método
        String mensagem = mediaService.calcularMedia(request);
        return ResponseEntity.ok(new RespostaDTO(mensagem));
    }

    /**
     * Endpoint 2 — Retorna data e hora local atual.
     *
     * GET /api/datetime
     *
     * Assinatura do método: getDataHoraLocal()
     * Retorno: ResponseEntity<RespostaDTO>
     *
     * @return data e hora local formatada
     */
    @GetMapping("/datetime")
    public ResponseEntity<RespostaDTO> getDataHoraLocal() {
        // Variável local com data/hora do momento da requisição
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);

        return ResponseEntity.ok(new RespostaDTO("Data e hora local: " + dataHoraFormatada));
    }
}

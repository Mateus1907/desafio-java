package com.desafio.api.controller;

import com.desafio.api.dto.RespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * Handler global de exceções.
 *
 * Conceito demonstrado:
 * - CLASSE com responsabilidade única (tratar erros)
 * - HERANÇA implícita de Object e uso de anotações Spring
 * - ENCAPSULAMENTO do tratamento de erros em uma classe separada
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata erros de validação do @Valid nos DTOs.
     *
     * Assinatura: handleValidationErrors(MethodArgumentNotValidException)
     * Retorno: ResponseEntity<RespostaDTO>
     *
     * @param ex exceção de validação lançada pelo Spring
     * @return resposta 400 com mensagens de erro
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespostaDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        // Variável local — coleta todas as mensagens de erro de validação
        String erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RespostaDTO("Erro de validação: " + erros));
    }
}

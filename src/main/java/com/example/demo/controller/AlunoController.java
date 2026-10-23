package com.example.demo.controller;

import com.example.demo.entity.Aluno;
import com.example.demo.service.AlunoServicePaty;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Tag(name = "Controlador do aluno ", description = "Gerencia os metodos HTTP do aluno")
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    private final AlunoServicePaty service;

    public AlunoController(AlunoServicePaty service) {
        this.service = service;
    }

    @Operation(summary = "Cria um aluno",
        description = "Retorna um novo aluno")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201",
                    description = "O cliente foi criado com sucesso"),
            @ApiResponse(responseCode = "400",
                    description = "Erro na validação dos dados inseridos pelo usuario")
    })
    @PostMapping
    public ResponseEntity<Aluno> criar(@Valid @RequestBody Aluno aluno){
        ResponseEntity.ok(service.criar(aluno));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aluno.getId())
                .toUri();

                return ResponseEntity.created(uri).body(aluno);
    }

}

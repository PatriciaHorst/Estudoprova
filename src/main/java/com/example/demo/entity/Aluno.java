package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {


    private int id;

    @NotBlank(message = "O nome precisa ser informado")
    @Size(min= 5, max= 100, message = "O nome deve ter entre 5 a 100 caracteres")
    @Schema(description = "Atributo que informa o nome do aluno")
    private String nome;

    @NotNull
    @Schema
    private long cpf;

    @NotBlank
    @Schema
    private String dataNascimento;

    @NotBlank
    @Size
    @Schema
    private String endereço;
}

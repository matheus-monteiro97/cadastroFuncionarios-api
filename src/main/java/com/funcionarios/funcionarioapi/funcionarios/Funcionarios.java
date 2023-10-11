package com.funcionarios.funcionarioapi.funcionarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table (name = "TB_FUNCIONARIOS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private int idade;
    private String cpf;
    private String profissao;
    private double salario;


}

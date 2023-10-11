package com.funcionarios.funcionarioapi.funcResources;

import com.funcionarios.funcionarioapi.funcionarios.Funcionarios;
import com.funcionarios.funcionarioapi.funcionariosDTO.FuncionariosDTO;
import com.funcionarios.funcionarioapi.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/api")

public class FuncionariosResources {

    @Autowired
    Repository repository;

    @GetMapping ("/funcionarios")
    public List <Funcionarios> listaFuncionarios () {
        return repository.findAll();
    }

    @GetMapping ("/funcionarios/ {id}")
    public Funcionarios listaFuncionarioUnico (@PathVariable (value = "id") long id) {
        return repository.findById(id);
    }

    @PostMapping ("/funcionarios")
    public Funcionarios salvaFuncionarios (@RequestBody Funcionarios funcionarios) {

        switch (funcionarios.getProfissao()) {
            case "medico":
                funcionarios.setSalario(funcionarios.getSalario() - (funcionarios.getSalario() * 0.2));
                System.out.println("Sindicato de Medicina");
                break;

            case "enfermeiro":
                funcionarios.setSalario(funcionarios.getSalario() - (funcionarios.getSalario() * 0.15));
                System.out.println("Sindicato de Enfermagem");
                break;

            case "recepcionista":
                funcionarios.setSalario(funcionarios.getSalario() - (funcionarios.getSalario() * 0.1));
                System.out.println("Sindicato de Recepcionistas");
                break;

            case "segurança":
                funcionarios.setSalario(funcionarios.getSalario() - (funcionarios.getSalario() * 0.05));
                System.out.println("Sindicato de Seguranças");
                break;

            default:
                System.out.println("Inválido, digite novamente a profissão.");
        }

        return repository.save(funcionarios);
    }

    @DeleteMapping("/funcionarios")
    public void deletaFuncionarios (@RequestBody Funcionarios funcionarios) {

        repository.delete(funcionarios);
    }

    @PutMapping("/funcionarios")
    public Funcionarios atualizaFuncionario (@RequestBody FuncionariosDTO funcionariosDTO) {

       var funcionarios =
               Funcionarios.builder()

                .nome(funcionariosDTO.getNome())
                .idade(funcionariosDTO.getIdade())
                .cpf(funcionariosDTO.getCpf())
                .profissao(funcionariosDTO.getProfissao())
                       .salario(funcionariosDTO.getSalario())

                .build();

        return repository.save(funcionarios);
    }
}



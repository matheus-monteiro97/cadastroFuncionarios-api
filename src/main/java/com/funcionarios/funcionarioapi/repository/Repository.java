package com.funcionarios.funcionarioapi.repository;

import com.funcionarios.funcionarioapi.funcionarios.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository <Funcionarios, Long> {

    Funcionarios findById (long id);

}

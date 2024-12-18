package com.vale.eccolimp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vale.eccolimp.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos de consulta personalizados podem ser adicionados aqui
}

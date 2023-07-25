package uis.edu.backendCliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uis.edu.backendCliente.models.Cliente;


public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    
}

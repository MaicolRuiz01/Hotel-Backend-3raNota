package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente ,Long > {
	
	Cliente findClienteByUsername(String username);

}

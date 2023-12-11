package Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente ,Long > {

}

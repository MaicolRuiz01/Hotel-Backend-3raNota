package com.example.demo.controller.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.entidades.Reserva;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}

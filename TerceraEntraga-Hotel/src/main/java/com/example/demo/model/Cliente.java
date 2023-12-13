package com.example.demo.model;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="fecha_nac")
	private String fechaNac;
	@Column(name="nacionalidad")
	private String nacionalidad;
	@Column(name="num_telefono")
	private String numTelefono;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_reserva")
	private List<Reserva> reservas = new ArrayList<>();
	
	public int getNumeroReservas() {
        return this.reservas.size();
    }
	
	public Cliente(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

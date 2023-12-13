package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reserva")
	private Long idReserva;
	@Column(name="fecha_entrada")
	private String fechaEntrada;
	@Column(name="fecha_salida")
	private String fechaSalida;
	@Column(name="forma_pago")
	private String formaPago;
	@Column(name="valor")
	private double valor;
	
	 
	 

}

package Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import Entidades.Reserva;
import Repositorio.ReservaRepository;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaRepository reservarepo;
	
	//obtiene todas las reservas
	@GetMapping
	public List<Reserva> getAllReservas() {

		List<Reserva> reservas = reservarepo.findAll();
		return reservas;
	}

	// obtiene la reserva por el id
	@GetMapping("/{id}")
	public Reserva getReserva(@PathVariable Long id) {

		Optional<Reserva> reserva = reservarepo.findById(id);
		if (reserva.isEmpty()) {
			return null;
		}
		return reserva.get();
	}
	//se crea una nueva reserva
	@PostMapping
	public Reserva nuevaReserva(Reserva reserva) {
		return reservarepo.save(reserva);
	}
	
	//actualizar reserva
	@PutMapping("/{id}")
	public Reserva actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
		Optional<Reserva> reservaAux = reservarepo.findById(id);
		
		if (reservaAux.isPresent()) {
			
			Reserva reservaReturn = reservaAux.get();
			reservaReturn.setFechaEntrada(reserva.getFechaEntrada());
			reservaReturn.setFechaSalida(reserva.getFechaSalida());
			reservaReturn.setFormaPago(reserva.getFormaPago());
			reservaReturn.setValor(reserva.getValor());
			 
			reservarepo.save(reservaReturn);
			return reservaReturn;
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Reserva eliminarReserva(@PathVariable Long id) {
		
		Optional<Reserva> reserva = reservarepo.findById(id);
		
		if (reserva.isPresent()) {
			
			Reserva reservaReturn = reserva.get();
			
			reservarepo.deleteById(id);
			
			return reservaReturn;
		}
		return null;
	}

}

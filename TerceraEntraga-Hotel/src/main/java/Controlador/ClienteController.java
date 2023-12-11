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

import Entidades.Cliente;
import Repositorio.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienterepo;
	
	@GetMapping
	public List<Cliente> getAllClientes() {

		List<Cliente> clientes = clienterepo.findAll();
		return clientes;
	}
	
	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable Long id) {

		Optional<Cliente> cliente = clienterepo.findById(id);
		if (cliente.isEmpty()) {
			return null;
		}
		return cliente.get();
	}
	
	@PostMapping
	public Cliente nuevoCliente(Cliente cliente) {
		return clienterepo.save(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> clienteAux = clienterepo.findById(id);
		
		if (clienteAux.isPresent()) {
			
			Cliente clienteReturn = clienteAux.get();
			clienteReturn.setNombre(cliente.getNombre());
			clienteReturn.setApellido(cliente.getApellido());
			clienteReturn.setFechaNac(cliente.getFechaNac());
			clienteReturn.setNumTelefono(cliente.getNumTelefono());
			clienteReturn.setNacionalidad(cliente.getNacionalidad());
			clienteReturn.setReservas(cliente.getReservas());
			 
			clienterepo.save(clienteReturn);
			return clienteReturn;
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Cliente eliminarCliente(@PathVariable Long id) {
		
		Optional<Cliente> cliente = clienterepo.findById(id);
		
		if (cliente.isPresent()) {
			
			Cliente clienteReturn = cliente.get();
			
			clienterepo.deleteById(id);
			
			return clienteReturn;
		}
		return null;
	}
	
	
}

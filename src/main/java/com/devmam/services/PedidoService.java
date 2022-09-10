package com.devmam.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmam.domain.Pedido;
import com.devmam.repositories.PedidoRepository;
import com.devmam.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
	 	Optional<Pedido> obj = repo.findById(id);
	 	return obj.orElseThrow( ()-> new ObjectNotFoundException(""
	 			+ "Pedido não encontrado! " + id + ", Tipo: " + Pedido.class.getName()) );
	 }
}

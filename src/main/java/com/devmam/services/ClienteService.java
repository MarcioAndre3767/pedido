package com.devmam.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmam.domain.Cliente;
import com.devmam.repositories.ClienteRepository;
import com.devmam.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
	 	Optional<Cliente> obj = repo.findById(id);
	 	return obj.orElseThrow( ()-> new ObjectNotFoundException(""
	 			+ "Cliente não encontrado! " + id + ", Tipo: " + Cliente.class.getName()) );
	 		
	 }
	
}



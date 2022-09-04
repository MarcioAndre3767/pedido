package com.devmam.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmam.domain.Categoria;
import com.devmam.repositories.CategoriaRepository;
import com.devmam.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
	 	Optional<Categoria> obj = repo.findById(id);
	 	return obj.orElseThrow( ()-> new ObjectNotFoundException(""
	 			+ "Objeto não encontrado! " + id + ", Tipo: " + Categoria.class.getName()) );
	 		
	 }
	
}



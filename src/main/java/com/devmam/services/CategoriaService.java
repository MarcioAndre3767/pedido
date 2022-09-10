package com.devmam.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.devmam.domain.Categoria;
import com.devmam.repositories.CategoriaRepository;
import com.devmam.services.exceptions.DateIntegrityException;
import com.devmam.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
	 	Optional<Categoria> obj = repo.findById(id);
	 	return obj.orElseThrow( ()-> new ObjectNotFoundException(""
	 			+ "Categoria não encontrada! " + id + ", Tipo: " + Categoria.class.getName()) );
	 }
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DateIntegrityException("Não é possível deletar uma categoria que"
					+ " possui produtos,");
		}
		
		
	}
	
}




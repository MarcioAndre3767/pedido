package com.devmam.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmam.domain.Categoria;
import com.devmam.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
//		Categoria obj = service.buscar(id);
//		
//		return ResponseEntity.ok().body(obj);
//	}
	
}

/*
 public Categoria find(Integer id) {
 	Optional<Categoria> obj = repo.findById(id);
 	return obj.orElse(null);
 }
 
 */

/*
 categoriaRepository.savell(Arrays.asList(cat1, cat2))
 */

/* video
 public Categoria find(Integer id) {
 	Optional<Categoria> obj = repo.findById(id);
 	return obj.orElseThrow() -> new ObjectNotFoundException (
 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
 }
 */







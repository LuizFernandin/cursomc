package br.com.luiz.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luiz.cursomc.domain.Categoria;
import br.com.luiz.cursomc.repositories.CategoriaRepository;
import br.com.luiz.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
 		obj.setId(null);
 		return repo.save(obj);
 	}
	
	public Categoria update(Categoria obj) {
 		find(obj.getId());
 		return repo.save(obj);
 	}
	
}

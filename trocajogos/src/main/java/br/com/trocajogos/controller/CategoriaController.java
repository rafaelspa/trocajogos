package br.com.trocajogos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.olimposistema.aipa.dao.DAO;
import br.com.olimposistema.aipa.vraptorcrud.CrudRest;
import br.com.trocajogos.model.Categoria;

@Controller
@Path("categoria")
public class CategoriaController extends CrudRest<Categoria> {
	
	@Inject Result result;
	protected DAO<Categoria> dao;
	
	@Inject
	public CategoriaController(DAO<Categoria> dao) {
		super(Categoria.class, dao);
		this.dao = dao;
	}
	
	@Deprecated public CategoriaController() {this(null);}
	
	
}

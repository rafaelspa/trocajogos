package br.com.trocajogos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.olimposistema.aipa.dao.DAO;
import br.com.trocajogos.dao.TrocaDAO;
import br.com.trocajogos.model.Categoria;
import br.com.trocajogos.model.Troca;

@Controller
@Path("trocas")
public class TrocasController {
	
	@Inject Result result;
	@Inject TrocaDAO trocaDao;
	@Inject DAO<Categoria> categoriaDao;

	@IncludeParameters
	@Get("")
	public void trocas(Troca filtro) {
		result.include("categorias", categoriaDao.selectAll());
		
		if(filtro != null) {
			result.include("trocas", trocaDao.filter(filtro));
			result.include("totalTrocas", trocaDao.filterTotal(filtro));
		}
		else result.include("trocas", trocaDao.selectAll());
	}
}

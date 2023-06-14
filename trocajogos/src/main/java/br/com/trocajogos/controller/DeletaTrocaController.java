package br.com.trocajogos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.trocajogos.dao.TrocaDAO;
import br.com.trocajogos.interceptors.SomenteLogado;
import br.com.trocajogos.model.Troca;

@Controller
@Path("deletatroca")
public class DeletaTrocaController {
	
	@Inject TrocaDAO trocaDao;
	@Inject Result result;

	@Get("/{troca.id}")
	@SomenteLogado
	public void deletatroca(Troca troca) {
		trocaDao.delete(troca);
		result.redirectTo(TrocasController.class).trocas(null);
	}
}

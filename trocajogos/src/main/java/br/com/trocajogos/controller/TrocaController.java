package br.com.trocajogos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.trocajogos.dao.TrocaDAO;
import br.com.trocajogos.model.Troca;

@Controller
@Path("produto")
public class TrocaController {
	
	@Inject TrocaDAO trocaDao;
	@Inject Result result;
	
	@Get("")
	public void listagemDeTrocas() {
		List<Troca> trocas = trocaDao.selectAll();
		
		result.use(Results.json())
		.withoutRoot()
		.from(trocas)
		.include("imagem")
		.serialize();
	}
	
}

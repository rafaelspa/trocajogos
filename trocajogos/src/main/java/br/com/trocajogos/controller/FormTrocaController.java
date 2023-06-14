package br.com.trocajogos.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.olimposistema.aipa.dao.DAO;
import br.com.olimposistema.aipa.imagem.Imagem;
import br.com.trocajogos.dao.TrocaDAO;
import br.com.trocajogos.interceptors.SomenteLogado;
import br.com.trocajogos.model.Categoria;
import br.com.trocajogos.model.Troca;

@Controller
@Path("formtroca")
public class FormTrocaController {
	
	@Inject Validator validator;
	@Inject TrocaDAO trocaDao;
	@Inject DAO<Categoria> categoriaDao;
	@Inject DAO<Imagem> imagemDao;
	@Inject Result result;

	@Get("") @SomenteLogado
	public void formtroca(Troca troca) {
		result.include("categorias",categoriaDao.selectAll());
		if (troca.getId() > 0) {
			Troca trocaDoBanco = trocaDao.selectPorId(troca);
			result.include("troca", trocaDoBanco);
		}
	}
	
	@IncludeParameters
	@SomenteLogado
	@Post("salvaTroca")
	public void salvaTroca(@Valid Troca troca) {
		imagemDao.insertOrUpdate(troca.getImagem());
		validator.onErrorRedirectTo(this).formtroca(troca);
		trocaDao.insertOrUpdate(troca);
		result.redirectTo(TrocasController.class).trocas(null);
	}
}

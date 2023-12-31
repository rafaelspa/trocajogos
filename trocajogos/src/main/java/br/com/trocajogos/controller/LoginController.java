package br.com.trocajogos.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.trocajogos.dao.UsuarioDAO;
import br.com.trocajogos.model.Usuario;

@Controller
@Path("login")
public class LoginController {
	
	@Inject Result result;
	@Inject Validator validator;
	@Inject UsuarioDAO usuarioDao;
	@Inject HttpSession session;

	@Get("")
	public void login() {
	}
	
	@IncludeParameters
	@Post("autenticar")
	public void autenticar(
			@NotEmpty String email,
			@NotEmpty String senha) {
		
		validator.onErrorRedirectTo(this).login();
		
		Usuario usuario = usuarioDao.existeUsuarioCom(email,senha);
		
		validator.addIf(usuario == null, new SimpleMessage("erro", "Email ou Senha Invalidos"));
		validator.onErrorRedirectTo(this).login();
		
		session.setAttribute("usuarioLogado", usuario);
		
		//autenticar usuario
		result.redirectTo(TrocasController.class).trocas(null);
	}
}

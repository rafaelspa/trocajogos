package br.com.trocajogos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.olimposistema.aipa.model.Model;

@Entity
public class Categoria extends Model {

	@NotEmpty
	private String nome;
	
	@OneToMany(mappedBy="categoria")
	private List<Troca> trocas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

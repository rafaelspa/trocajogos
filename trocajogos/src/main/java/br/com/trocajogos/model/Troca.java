package br.com.trocajogos.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.olimposistema.aipa.dao.filter.FiltrableName;
import br.com.olimposistema.aipa.imagem.Imagem;
import br.com.olimposistema.aipa.model.Model;
import br.com.trocajogos.rn.ConverteDataDeEnParaCalendar;
import br.com.trocajogos.rn.FormataDeDoubleParaReais;

@Entity
public class Troca extends Model{
	
	@NotEmpty
	@FiltrableName
	private String nomeJogo;
	
	@NotEmpty @Type(type="text")
	private String descricao;
	
	@NotNull @Min(0)
	private Double valor;
	
	@ManyToOne @NotNull
	private Categoria categoria;
	
	@Temporal(TemporalType.DATE) @NotNull
	private Calendar dataValidade;
	
	@OneToOne(
		cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, 
		fetch = FetchType.EAGER, 
		orphanRemoval = true  
	)
	private Imagem imagem;

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}
	
	public String getValorMoney() {
		String valorFormatado = new FormataDeDoubleParaReais().executa(valor);
		return valorFormatado;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}
	
	public String getDataValidadeFormatada() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataValidade.getTime());
		return dataFormatada;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public void setDataValidadeEn(String data) {
		if(data == null) return;	
		this.dataValidade = new ConverteDataDeEnParaCalendar().executa(data);
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	
}

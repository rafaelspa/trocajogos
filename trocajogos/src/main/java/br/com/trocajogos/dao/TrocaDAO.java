package br.com.trocajogos.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.olimposistema.aipa.dao.DAO;
import br.com.trocajogos.model.Categoria;
import br.com.trocajogos.model.Troca;

@RequestScoped
public class TrocaDAO extends DAO<Troca> {

	@Deprecated public TrocaDAO() {super(null,null);}
	
	@Inject
	public TrocaDAO(EntityManager em) {
		super(em, Troca.class);
	}
	
	public List<Troca> buscaTodosAsTrocasOrdenadoPeloNomeDoJogo(){
		
	  CriteriaBuilder cb = em.getCriteriaBuilder();
	  CriteriaQuery<Troca> q = cb.createQuery(Troca.class);
	  
	  Root<Troca> r = q.from(Troca.class);  
	  q.select(r)
	  .orderBy(cb.desc(r.get("nomeJogo")));
	  
	  
	  TypedQuery<Troca> query = em.createQuery(q);
	  List<Troca> trocas = query.getResultList();
	  return trocas;
	}
	
	public List<Troca> buscaPorCategoriaEspecifica(String categoria, Long id) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Troca> q = cb.createQuery(Troca.class);
		
		
		Root<Troca> r = q.from(Troca.class);
		Join<Troca, Categoria> jc = r.join("categoria", JoinType.INNER);
		
		q.select(r)
		.where(
			cb.and(
				cb.like(cb.lower(r.get("nomeJogo")), "%" + categoria + "%")),
				cb.equal(jc.get("id"), id)
			);
				
		
	    TypedQuery<Troca> query = em.createQuery(q);
		List<Troca> trocas = query.getResultList();
		return trocas;
		
	}
	
	public Long totalTrocas() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> q = cb.createQuery(Long.class);
		
		Root<Troca> r = q.from(Troca.class);
		q.multiselect(cb.count(r));
		
		
		TypedQuery<Long> query = em.createQuery(q);
		Long total = query.getSingleResult();
		return total;
	}

	

}

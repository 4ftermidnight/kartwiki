package br.com.aftermidnight.kartwiki.dao.hibernate;

import javax.persistence.EntityManager;

import br.com.aftermidnight.kartwiki.model.Grupo;

public class GrupoDAO extends HibernateGenericDAO<Grupo, Long> {

	private static final long serialVersionUID = 1L;


	public GrupoDAO() {
		super();
	}
	
	public GrupoDAO(EntityManager em) {
		super(em);
	}

}

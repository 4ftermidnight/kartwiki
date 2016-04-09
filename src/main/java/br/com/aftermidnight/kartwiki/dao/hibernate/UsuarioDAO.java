package br.com.aftermidnight.kartwiki.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.aftermidnight.kartwiki.model.Usuario;

public class UsuarioDAO extends HibernateGenericDAO<Usuario, Long> {

	private static final long serialVersionUID = 1L;


	public UsuarioDAO() {
		super();
	}
	
	public UsuarioDAO(EntityManager em) {
		super(em);
	}

	
	public Usuario buscarPorEmail(String email) {
		Usuario usuario = null;
		
		try {
			usuario = getEntityManager().createQuery("from Usuario where lower(email) = :email", Usuario.class)
				.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o e-mail informado
		}
		
		return usuario;
	}
}

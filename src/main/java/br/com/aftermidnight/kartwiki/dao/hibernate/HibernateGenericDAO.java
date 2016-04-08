package br.com.aftermidnight.kartwiki.dao.hibernate;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.aftermidnight.kartwiki.dao.GenericDAO;

public class HibernateGenericDAO<T, ID extends Serializable> implements GenericDAO<T, ID>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public HibernateGenericDAO() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public HibernateGenericDAO(EntityManager entityManager) {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
//	protected EntityManager getEntityManager() {
//		return entityManager;
//	}
	
	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	
	/* Buscar */
	@Override
	public T buscar(ID id) {
		return entityManager.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscarPorExemplo(T exemplo, String... propriedades) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(clazz);
		
		if (propriedades != null) {
			for (String propriedade : propriedades) {
				try {
					Object valor = PropertyUtils.getProperty(exemplo, propriedade);
					if (valor != null) {
						if (valor instanceof String) {
							criteria.add(Restrictions.ilike(propriedade, (String) valor, MatchMode.ANYWHERE));
						} else {
							criteria.add(Restrictions.eq(propriedade, valor));
						}
					}
				} catch (Exception e) {
					throw new RuntimeException("Propriedade não encontrada", e);
				}
			}
		}
		
		return criteria.list();
	}
	
	@Override
	public List<T> buscarComConsultaPaginada(String namedQuery, int first, int pageSize, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> buscarComConsultaPaginada(int first, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*Salvar*/
	@Override
	public void salvar(T entidade) {
		entityManager.merge(entidade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscarTodos() {
		String hql = "from "+clazz.getName()+" t";
		return entityManager.createQuery(hql).getResultList();	
	}
	

	/*Remove*/
	@Override
	public void remover(T entidade) {
		if(entidade != null){
			getEntityManager().remove(entidade);
			getEntityManager().flush();
		}
	}
	
	@Override
	public void remover(ID id) {
		remover(buscar(id));	
	}
	
	
	
	/*Utils*/
	@Override
	public Long contarTotalDeRegistros(Class<T> clazz) {
		return (Long) entityManager.createQuery("SELECT COUNT(obj) FROM " + clazz.getName() + " obj").getSingleResult();
	}
	
	@Override
	public Long contarTotalDeRegistros() {
		return (Long) entityManager.createQuery("SELECT COUNT(obj) FROM " + clazz.getName() + " obj").getSingleResult();
	}

	
	

}


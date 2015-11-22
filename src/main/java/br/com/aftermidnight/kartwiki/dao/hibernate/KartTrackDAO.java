package br.com.aftermidnight.kartwiki.dao.hibernate;

import javax.persistence.EntityManager;

import br.com.aftermidnight.kartwiki.model.KartTrack;

public class KartTrackDAO extends HibernateGenericDAO<KartTrack, Long> {

	public KartTrackDAO() {
		super();
	}
	
	public KartTrackDAO(EntityManager em) {
		super(em);
	}

}

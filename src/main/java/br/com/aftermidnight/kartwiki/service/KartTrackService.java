package br.com.aftermidnight.kartwiki.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.KartTrack;

public class KartTrackService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private KartTrackDAO dao;

	public List<KartTrack> filtrar(KartTrack filtro, String... string) {
		return null;
	}

	public List<KartTrack> obterTodosKartodromos() {
		return dao.buscarTodos();
	}
	
	

}

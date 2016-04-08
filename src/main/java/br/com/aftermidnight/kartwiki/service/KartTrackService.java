package br.com.aftermidnight.kartwiki.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.KartTrack;
import br.com.aftermidnight.kartwiki.util.jpa.Transactional;

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
	
	@Transactional
	public void salvar(KartTrack entidade) {
		dao.salvar(entidade);
	}
	
	@Transactional
	public void remover(KartTrack entidade) {
		dao.remover(entidade.getId());
	}
	
	

}

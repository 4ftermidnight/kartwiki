package br.com.aftermidnight.kartwiki.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.aftermidnight.kartwiki.dao.hibernate.GrupoDAO;
import br.com.aftermidnight.kartwiki.model.Grupo;
import br.com.aftermidnight.kartwiki.model.KartTrack;
import br.com.aftermidnight.kartwiki.util.jpa.Transactional;

public class GrupoService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoDAO dao;

	public List<KartTrack> filtrar(Grupo filtro, String... string) {
		return null;
	}

	public List<Grupo> obterTodos() {
		return dao.buscarTodos();
	}
	
	@Transactional
	public void salvar(Grupo entidade) {
		dao.salvar(entidade);
	}
	
	@Transactional
	public void remover(Grupo entidade) {
		dao.remover(entidade.getId());
	}
	
	

}

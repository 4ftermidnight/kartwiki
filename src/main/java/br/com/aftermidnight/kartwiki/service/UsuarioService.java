package br.com.aftermidnight.kartwiki.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.aftermidnight.kartwiki.dao.hibernate.UsuarioDAO;
import br.com.aftermidnight.kartwiki.model.Usuario;
import br.com.aftermidnight.kartwiki.util.jpa.Transactional;

public class UsuarioService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO dao;

	public List<Usuario> filtrar(Usuario filtro, String... string) {
		return null;
	}

	public List<Usuario> obterTodos() {
		return dao.buscarTodos();
	}
	
	@Transactional
	public void salvar(Usuario entidade) {
		dao.salvar(entidade);
	}
	
	@Transactional
	public void remover(Usuario entidade) {
		dao.remover(entidade.getId());
	}
	
	

}

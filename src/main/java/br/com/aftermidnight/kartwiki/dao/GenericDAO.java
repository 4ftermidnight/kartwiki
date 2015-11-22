package br.com.aftermidnight.kartwiki.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	
	public T buscar(ID id);
	public List<T> buscarTodos();
	public List<T> buscarPorExemplo(T entidade, String... propriedades);
	public List<T> buscarComConsultaPaginada(String namedQuery, int first, int pageSize, Class<T> clazz);
	public List<T> buscarComConsultaPaginada(int first, int pageSize);
	public Integer contarTotalDeRegistros(Class<T> clazz);
	public Integer contarTotalDeRegistros();
	
	public void salvar(T entidade);
	public void remover(T entidade);
	public void remover(ID id);
	

}
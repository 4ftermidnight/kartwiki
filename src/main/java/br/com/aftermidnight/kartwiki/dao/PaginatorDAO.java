package br.com.aftermidnight.kartwiki.dao;

import java.util.List;
/*Criado para deixar a paginação generica,... TODO: Criar um DAO Genérico já contemplando isso*/
public interface PaginatorDAO<T> {

	public List<T> buscarComPaginacao(int first, int pageSize);
	
	public Long encontrarQuantidadeTotal();
}

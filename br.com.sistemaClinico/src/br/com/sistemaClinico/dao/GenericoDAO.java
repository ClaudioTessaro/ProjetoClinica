package br.com.sistemaClinico.dao;

import java.util.List;

import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public interface GenericoDAO<T> {
	
	void inserir(T obj) throws PersistenciaExcpetion;
	
	void atualizar(T obj) throws PersistenciaExcpetion;
	
	void deletar(Integer id) throws PersistenciaExcpetion;
	
	List<T> listarTodos() throws PersistenciaExcpetion;
	
	T buscarPorId(Integer id) throws PersistenciaExcpetion;

}

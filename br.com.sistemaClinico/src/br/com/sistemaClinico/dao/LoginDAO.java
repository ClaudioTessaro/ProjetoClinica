package br.com.sistemaClinico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;



import br.com.sistemaClinico.conector.ConexaoUtil;
import br.com.sistemaClinico.dto.LoginDTO;
import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public class LoginDAO implements GenericoDAO<LoginDTO> {
	
	public boolean Logar(LoginDTO loginDTO) throws PersistenciaExcpetion {
		boolean logado = false;
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection(); // aqui criamos a conexão com o banco
			
			String sql = "Select * from tb_login Where login = ? and senha = ?"; //script do sql para acessar os atributos necessarios para fazer o login do usuario, cada interrogação será recuperada mais abaixo;
			
			PreparedStatement statement = connection.prepareStatement(sql); //criamos a ponte necessaria para linkar o sql no banco,
			statement.setString(1, loginDTO.getLogin()); //buscamos dentro da classe DTO o valor no banco de dados
			statement.setString(2, loginDTO.getSenha());

			ResultSet resultSet = statement.executeQuery(); // metodo responsavel por executar a query. O executeQuery só é usado quando temos uma query com select;
			logado = resultSet.next(); //ele irá procurar em cada linha da tabela o resultado, assim que for verdadeiro ou falso o resultado logado será modificado;
			connection.close();//aqui fechamos a conexão com o banco;
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
			
		return logado;	
	}
	

	@Override
	public void inserir(LoginDTO obj) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(LoginDTO obj) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LoginDTO> listarTodos() throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginDTO buscarPorId(Integer id) throws PersistenciaExcpetion {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

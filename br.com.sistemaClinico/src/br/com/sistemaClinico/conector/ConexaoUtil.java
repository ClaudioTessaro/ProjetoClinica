//Classe responsavel por criar a conexão com o banco de dados

package br.com.sistemaClinico.conector;


import java.sql.DriverManager;
import java.sql.SQLException;



import java.util.ResourceBundle;

import java.sql.Connection;

public class ConexaoUtil {

	private static ResourceBundle config;  //A variavel serve para capturar o arquivo config, onde estão as propriedades para conectar. Esse tipo de arquivo é utilizado no padrão de projeto DAO
	private static ConexaoUtil conexaoUtil; //

	//Construtor responsavel por recuperar o arquivo;
	public ConexaoUtil() {
		config = ResourceBundle.getBundle("config");	//Metodo responsavel por buscar o arquivo;

	}

	//Metodo responsavel por verificar se existe instancia do banco, e caso não tenha, criar a instancia;
	public static ConexaoUtil getInstance() {
		if(conexaoUtil == null) {
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;

	}
	//Metodo que irá fazer a conexão com o banco de dados.
	public Connection getConnection() {
		String url = config.getString("aprendendodbc.conexao"); //O metodo getString passa por parametro o nome que ser encontra no arquivo config.
		String user = config.getString("aprendendodbc.usuario");
		String password = "";
		try {
			Class.forName(config.getString("aprendendodbc.driver"));
			return (Connection) DriverManager.getConnection(url,user,password);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null; //Caso não haja conexão, retornará nulo;
	}
}



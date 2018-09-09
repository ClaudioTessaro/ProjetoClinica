package br.com.sistemaClinico.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import br.com.sistemaClinico.conector.ConexaoUtil;
import br.com.sistemaClinico.dto.ContatoDTO;
import br.com.sistemaClinico.dto.EnderecoDTO;
import br.com.sistemaClinico.dto.PacienteDTO;
import br.com.sistemaClinico.dto.ProntuarioDTO;
import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public class PacienteDAO implements GenericoDAO<PacienteDTO>{
	
	public int insereEndereco (EnderecoDTO enderecoDTO) throws PersistenciaExcpetion {//O metodo será do tipo inteiro, porque iremos gerar um valor da chave para recuperarmos ao final, para criarmos o relacionamento {
		int chaveEndereco = 0; //essa chave será a chave recuperada responsavel pela chave estrangeira;
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection(); // Mesma coisa feita pela classe LoginDAO;
			
			String sql ="INSERT INTO TB_ENDERECO (LOGRADOURO,BAIRRO,CIDADE,NUMERO) VALUES(?,?,?,?)"; 
			
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Esse tipo de metodo sobrescrito com os dois parametros passado, me retornará uma chave que será utilizada como chave estrangeira;
			statement.setString(1, enderecoDTO.getLogradouro());
			statement.setString(2, enderecoDTO.getBairro());
			statement.setString(3, enderecoDTO.getCidade());
			statement.setInt(4, enderecoDTO.getNumero());
					
			statement.execute();
			ResultSet result = statement.getGeneratedKeys();  //Ele recuperará a chave estrangeira;
			if(result.next()) {
				chaveEndereco = result.getInt(1); 
			}
			connection.close();
						
		}catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(),e);
		}
		
		return chaveEndereco;
		}
	
	public int insereContato (ContatoDTO contatoDTO) throws PersistenciaExcpetion {
		int chaveContato= 0;
		
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection(); // Mesma coisa feita pela classe LoginDAO;
			
			String sql ="INSERT INTO TB_CONTATO (CELULAR,TELEFONEFIXO,EMAIL) VALUES(?,?,?)"; 
			
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Esse tipo de metodo sobrescrito com os dois parametros passado, me retornará uma chave que será utilizada como chave estrangeira;
			statement.setInt(1, contatoDTO.getCelular());
			statement.setInt(2, contatoDTO.getTelefoneFixo());
			statement.setString(3, contatoDTO.getEmail());
					
			statement.execute();
			ResultSet result = statement.getGeneratedKeys();  
			if(result.next()) {
				chaveContato = result.getInt(1); 
			}
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(),e);		
		}
		
		return chaveContato;
	}
	
	public int insereProntuario (ProntuarioDTO prontuarioDTO) throws PersistenciaExcpetion  {
		int chaveProntuario = 0;
		
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection(); // Mesma coisa feita pela classe LoginDAO;
			
			String sql ="INSERT INTO TB_PRONTUARIO (DATADEENTRADA,EXAMEINICIAL,DATADESAIDA,MEDICAMENTOS,TRATAMENTOS) VALUES(?,?,?,?,?)"; 
			
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Esse tipo de metodo sobrescrito com os dois parametros passado, me retornará uma chave que será utilizada como chave estrangeira;
			statement.setDate(1, new Date(prontuarioDTO.getDataDeEntrada().getTime()));
			statement.setString(2, prontuarioDTO.getExameInicial());
			statement.setDate(3, new Date(prontuarioDTO.getDataDeSaida().getTime()));
			statement.setString(4,prontuarioDTO.getMedicamentos());
			statement.setString(5, prontuarioDTO.getTratamentos());
								
			statement.execute();
			ResultSet result = statement.getGeneratedKeys();  //Ele recuperará a chave estrangeira;
			if(result.next()) {
				chaveProntuario = result.getInt(1); 
			}
			connection.close();
						
		}catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(),e);
						
		}	
		return chaveProntuario;
	}
	
	
	@Override
	public void inserir(PacienteDTO pacienteDTO) throws PersistenciaExcpetion {
		try {
			int chaveEndereco = insereEndereco(pacienteDTO.getEnderecoDTO()); //para recuperar a chave de acesso do banco;
			int chaveContato = insereContato(pacienteDTO.getContatoDTO());
			int chaveProntuario = insereProntuario(pacienteDTO.getProntuarioDTO());
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "INSERT INTO TB_PACIENTE (NOMEPACIENTE,SEXOPACIENTE,DTNASCIMENTO,CPF,tb_endereco_idendereco,tb_prontuario_id_prontuario,tb_contato_id_contato) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pacienteDTO.getNomePaciente());
			statement.setString(2, String.valueOf(pacienteDTO.getSexoPaciente()));
			statement.setDate(3, new Date(pacienteDTO.getDtNascimento().getTime()));
			statement.setLong(4, pacienteDTO.getCPF());
			statement.setInt(5, chaveEndereco);
			statement.setInt(6, chaveProntuario);
			statement.setInt(7, chaveContato);
			
			statement.execute();
			connection.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaExcpetion(e.getMessage(),e);
			
		}
				
	}

	@Override
	public void atualizar(PacienteDTO obj) throws PersistenciaExcpetion {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		String sql = "UPDATE SET NOMEPACIENTE =?"
		+"SEXOPACIENTE = ?"
		+"DTNASCIMENTO = ? "
		+"CPF = ?";
		
		try {
			connection.prepareStatement(sql);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
				
		
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaExcpetion {
		
		
	}
	
	
	public EnderecoDTO buscarEndereco(Integer idEndereco) throws PersistenciaExcpetion {
		EnderecoDTO enderecoDTO = null;
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM TB_ENDERECO WHERE IDENDERECO=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idEndereco);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				enderecoDTO = new EnderecoDTO();
				enderecoDTO.setIdEndereco(result.getInt(1));
				enderecoDTO.setLogradouro(result.getString(2));
				enderecoDTO.setBairro(result.getString(3));
				enderecoDTO.setCidade(result.getString(4));
				enderecoDTO.setNumero(result.getInt(5));
			}
			connection.close();
			} catch (SQLException e) {
				throw new PersistenciaExcpetion(e.getMessage(),e);
				
			}
		
		return enderecoDTO;
	}
	
	
	public ContatoDTO buscarContato (Integer idContato) throws PersistenciaExcpetion {
		ContatoDTO contatoDTO = null;
		try {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		String sql = "SELECT * FROM TB_CONTATO WHERE ID_CONTATO=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idContato);
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			contatoDTO = new ContatoDTO();
			contatoDTO.setIdContato(result.getInt(1));
			contatoDTO.setCelular(result.getInt(2));
			contatoDTO.setTelefoneFixo(result.getInt(3));
			contatoDTO.setEmail(result.getString(4));
			
		}
		connection.close();
		} catch (SQLException e) {
			throw new PersistenciaExcpetion(e.getMessage(),e);
			
		}
		
		return contatoDTO;
	}
	
	
	public ProntuarioDTO buscarProntuario(Integer idProntuario) throws PersistenciaExcpetion {
		ProntuarioDTO prontuarioDTO = new ProntuarioDTO();
		Connection connection = ConexaoUtil.getInstance().getConnection();
		String sql = "Select * from tb_prontuario where ID_prontuario = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idProntuario);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				prontuarioDTO.setIdProntuario(result.getInt(1));
				prontuarioDTO.setDataDeEntrada(result.getDate(2));
				prontuarioDTO.setExameInicial(result.getString(3));
				prontuarioDTO.setDataDeSaida(result.getDate(4));
				prontuarioDTO.setMedicamentos(result.getString(5));
				prontuarioDTO.setTratamentos(result.getString(6));
				
			}
			connection.close();
			
		} catch (SQLException e) {
			throw new PersistenciaExcpetion(e.getMessage(),e);
		}
		
		
		
		
		return prontuarioDTO;
	}
	

	@Override
	public List<PacienteDTO> listarTodos() throws PersistenciaExcpetion {
		List<PacienteDTO> listaTodos = new ArrayList<PacienteDTO>();
		
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM TB_Paciente";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				PacienteDTO pacienteDTO = new PacienteDTO();
				pacienteDTO.setIdPaciente(result.getInt("id_paciente"));
				pacienteDTO.setNomePaciente(result.getString("nomePaciente"));
				pacienteDTO.setSexoPaciente(result.getString("sexoPaciente").charAt(0));
				pacienteDTO.setDtNascimento(result.getDate("dtNascimento"));
				pacienteDTO.setCPF(result.getLong("cpf"));
				pacienteDTO.setProntuarioDTO(buscarProntuario(result.getInt("tb_prontuario_id_prontuario")));
				pacienteDTO.setEnderecoDTO(buscarEndereco(result.getInt("tb_endereco_idendereco")));
				pacienteDTO.setContatoDTO(buscarContato(result.getInt("tb_contato_id_contato")));
				
				listaTodos.add(pacienteDTO);
			}
			
			connection.close();
			
			
		} catch (SQLException e) {
			throw new PersistenciaExcpetion(e.getMessage(),e);
		}
				
		return listaTodos;
	}

	@Override
	public PacienteDTO buscarPorId(Integer id) throws PersistenciaExcpetion {
		
		
		
		return null;
	}
	

}

package br.com.sistema.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.sistemaClinico.dao.PacienteDAO;
import br.com.sistemaClinico.dto.ContatoDTO;
import br.com.sistemaClinico.dto.EnderecoDTO;
import br.com.sistemaClinico.dto.PacienteDTO;
import br.com.sistemaClinico.dto.ProntuarioDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;

public class PacienteBO {
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public void Cadastrar(PacienteDTO pacienteDTO) throws NegocioException {
		try {
			PacienteDAO pacienteDAO = new PacienteDAO();
			pacienteDAO.inserir(pacienteDTO);
		}catch(Exception e) {
			throw new NegocioException("Cadastro não realizado");
		}
	}
	
	public List<PacienteDTO> listagem() throws NegocioException {
		try {
			PacienteDAO pacienteDAO = new PacienteDAO();
			return pacienteDAO.listarTodos();
		} catch(Exception exception) {
			throw new NegocioException(exception.getMessage());
		} 
	}
	
	public String[][] listagem(List<Integer> idsPessoas) throws NegocioException {
		int numCols = 17;
		String[][] listaRetorno = null;
		try {
			PacienteDAO pacienteDAO = new PacienteDAO();
			List<PacienteDTO> lista = pacienteDAO.listarTodos();
			listaRetorno = new String[lista.size()][numCols];
			
			for (int i = 0; i < lista.size(); i++) {
				PacienteDTO pessoa = lista.get(i);
				EnderecoDTO enderecoDTO = pessoa.getEnderecoDTO();
				ContatoDTO contatoDTO = pessoa.getContatoDTO();
				ProntuarioDTO prontuarioDTO = pessoa.getProntuarioDTO();
				
				
				listaRetorno[i][0] = pessoa.getIdPaciente().toString();
				idsPessoas.add(pessoa.getIdPaciente());
				listaRetorno[i][1] = pessoa.getNomePaciente();
				listaRetorno[i][2] = pessoa.getSexoPaciente() == 'M' ? "Masculino" : "Feminino";
				listaRetorno[i][3] = pessoa.getCPF().toString();
				listaRetorno[i][4] = dateFormat.format(pessoa.getDtNascimento());
				listaRetorno[i][5] = enderecoDTO.getLogradouro();
				listaRetorno[i][6] = enderecoDTO.getBairro();
				listaRetorno[i][7] = enderecoDTO.getCidade();
				listaRetorno[i][8] = enderecoDTO.getNumero().toString();
				listaRetorno[i][9] = contatoDTO.getCelular().toString();
				listaRetorno[i][10] = contatoDTO.getTelefoneFixo().toString();
				listaRetorno[i][11] = contatoDTO.getEmail();
				listaRetorno[i][12] = dateFormat.format(prontuarioDTO.getDataDeEntrada());
				listaRetorno[i][13] = prontuarioDTO.getExameInicial();
				listaRetorno[i][14] = prontuarioDTO.getMedicamentos();
				listaRetorno[i][15] = prontuarioDTO.getTratamentos();
				listaRetorno[i][16] = dateFormat.format(prontuarioDTO.getDataDeSaida());
				
				
				
			
			}
		} catch(Exception exception) {
			throw new NegocioException(exception.getMessage());
		}
		return listaRetorno;
	}

}

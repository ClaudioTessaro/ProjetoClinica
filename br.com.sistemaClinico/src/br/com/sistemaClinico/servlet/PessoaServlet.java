package br.com.sistemaClinico.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.bo.PacienteBO;
import br.com.sistemaClinico.dto.ContatoDTO;
import br.com.sistemaClinico.dto.EnderecoDTO;
import br.com.sistemaClinico.dto.PacienteDTO;
import br.com.sistemaClinico.dto.ProntuarioDTO;



/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/pessoa")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String proximaPagina = "home.jsp";
		try {
		PacienteBO pacienteBO = new PacienteBO();
		if(acao.equals("Cadastrar")) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String cpf = request.getParameter("cpf");
			String nome = request.getParameter("nome");
			String dtNasc = request.getParameter("dtNasc");
			String sexo = request.getParameter("sexo");
			String logradouro = request.getParameter("logradouro");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String numero = request.getParameter("numero");
			String celular = request.getParameter("celular");
			String email = request.getParameter("email");
			String fixo = request.getParameter("fixo");
			String dtEntrada= request.getParameter("dtEntrada");
			String dtSaida = request.getParameter("dtSaida");
			String exameInicial = request.getParameter("exameinicial");
			String tratamentos =request.getParameter("tratamentos");
			String medicamentos = request.getParameter("medicamentos");
			
						
			PacienteDTO pacienteDTO = new PacienteDTO();
			pacienteDTO.setCPF(Long.parseLong(cpf));
			pacienteDTO.setDtNascimento(dateFormat.parse(dtNasc));
			
			EnderecoDTO enderecoDTO = new EnderecoDTO();
			enderecoDTO.setBairro(bairro);
			
			enderecoDTO.setCidade(cidade);
			enderecoDTO.setLogradouro(logradouro);
			enderecoDTO.setNumero(Integer.parseInt(numero));
			
			ContatoDTO contatoDTO = new ContatoDTO();
			contatoDTO.setCelular(Integer.parseInt(celular));
			contatoDTO.setEmail(email);
			contatoDTO.setTelefoneFixo(Integer.parseInt(fixo));
			
			ProntuarioDTO prontuarioDTO = new ProntuarioDTO();
			prontuarioDTO.setDataDeEntrada(dateFormat.parse(dtEntrada));
			prontuarioDTO.setDataDeSaida(dateFormat.parse(dtSaida));
			prontuarioDTO.setExameInicial((exameInicial));
			prontuarioDTO.setMedicamentos((medicamentos));
			prontuarioDTO.setTratamentos((tratamentos));
			
			
			pacienteDTO.setEnderecoDTO(enderecoDTO);
			pacienteDTO.setProntuarioDTO(prontuarioDTO);
			pacienteDTO.setContatoDTO(contatoDTO);
			
			pacienteDTO.setNomePaciente(nome);
			pacienteDTO.setSexoPaciente(sexo.charAt(0));
			
			pacienteBO.Cadastrar(pacienteDTO);
			request.setAttribute("msg", "Cadastro efetuado com sucesso!");
			proximaPagina = "pessoa?acao=listar";
		}else if(acao.equals("listar")){
			
			List<PacienteDTO> lista = pacienteBO.listagem();
			request.setAttribute("listaPessoas", lista);			
			proximaPagina = "lista.jsp";
		}
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
				
			}
			request.getRequestDispatcher(proximaPagina).forward(request, response);
		}
	}



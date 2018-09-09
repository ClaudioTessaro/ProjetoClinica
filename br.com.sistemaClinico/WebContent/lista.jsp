<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.sistemaClinico.dao.PacienteDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="br.com.sistemaClinico.dto.PacienteDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Dados</title>
</head>
<body>
<%
		String msg = (String) request.getAttribute("msg");
	%>
	<%= msg != null ? msg : "" %>
<table border="1" cellpadding="5" cellspacing="0" width="500px">
		<tr style="color: white" bgcolor="black" align="center">
			<td>Nome Paciente</td>
			<td>Sexo</td>
			<td>CPF</td>
			<td>Nascimento</td>
			<td>Data de entrada</td>
			<td>Data de saida</td>
			<td>Exames</td>
			<td>Tratamento</td>
			<td>Medicamentos</td>
			<td>Logradouro</td>
			<td>Bairro</td>
			<td>Cidade</td>
			<td>Numero</td>
			<td>Telefone Celular</td>
			<td>Telefone Fixo</td>
			<td>E-mail</td>
			
		</tr>
		
		<%
			PacienteDAO dao = new PacienteDAO();
			List<PacienteDTO> lista = dao.listarTodos();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (PacienteDTO pacienteDTO : lista) {
		%>
			<tr>
				
				<td><%= pacienteDTO.getNomePaciente() %></td>
				<td><%= pacienteDTO.getSexoPaciente() %></td>
				<td><%= pacienteDTO.getCPF() %></td>
				<td><%= dateFormat.format(pacienteDTO.getDtNascimento()) %></td>
				<td><%= dateFormat.format(pacienteDTO.getProntuarioDTO().getDataDeEntrada()) %></td>
				<td><%= dateFormat.format(pacienteDTO.getProntuarioDTO().getDataDeSaida()) %></td>
				<td><%= pacienteDTO.getProntuarioDTO().getExameInicial() %></td>
				<td><%= pacienteDTO.getProntuarioDTO().getTratamentos() %></td>
				<td><%= pacienteDTO.getProntuarioDTO().getMedicamentos() %></td>
				<td><%= pacienteDTO.getEnderecoDTO().getLogradouro() %></td>
				<td><%= pacienteDTO.getEnderecoDTO().getBairro() %></td>
				<td><%= pacienteDTO.getEnderecoDTO().getCidade() %></td>
				<td><%= pacienteDTO.getEnderecoDTO().getNumero() %></td>
				<td><%= pacienteDTO.getContatoDTO().getCelular() %></td>
				<td><%= pacienteDTO.getContatoDTO().getTelefoneFixo() %></td>
				<td><%= pacienteDTO.getContatoDTO().getEmail() %></td>
				
			</tr>
		<%
			}
		%>
	</table>


</body>
</html>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	Cadastrando usuario
</body>
	<form action="pessoa?acao=Cadastrar" method="post">
		<fieldset>
			<legend>Pessoa</legend>
		
			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<%= msg != null ? msg : "" %>
		
			<table>
				<tr>
					<td>Nome:</td>
					<td>
						<input type="text" name="nome"/>
					</td>
				</tr>
				<tr>
					<td>Cpf:</td>
					<td>
						<input type="text" name="cpf"/>
					</td>
				</tr>
				<tr>
					<td>Dt. Nasc:</td>
					<td>
						<input type="text" name="dtNasc"/>
					</td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Sexo</legend>
		
			<table>
				<tr>
					<td>Sexo:</td>
					<td>
						<input type="radio" name="sexo" value="M" checked="checked"/> Masculino
						<input type="radio" name="sexo" value="F"/> Feminino
					</td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Endereço</legend>
		
			<table>
				<tr>
					<td>Logradouro:</td>
					<td>
						<input type="text" name="logradouro" /> 
					</td>
				</tr>
				<tr>
					<td>Bairro:</td>
					<td>
						<input type="text" name="bairro" /> 
					</td>
				</tr>
				<tr>
					<td>Cidade:</td>
					<td>
						<input type="text" name="cidade" /> 
					</td>
				</tr>
				<tr>
					<td>Número:</td>
					<td>
						<input type="text" name="numero" /> 
					</td>
				</tr>
				
				
			</table>
			</fieldset>
			<fieldset>
			<legend>Contato</legend>
		
			<table>
				<tr>
					<td>Celular:</td>
					<td>
						<input type="text" name="celular" /> 
					</td>
				</tr>
				<tr>
					<td>Fixo:</td>
					<td>
						<input type="text" name="fixo" /> 
					</td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td>
						<input type="text" name="email" /> 
					</td>
				</tr>
				</table>
					
		</fieldset>
		
		<fieldset>
			<legend>Prontuario</legend>
		
			<table>
				<tr>
					<td>Data de Entrada:</td>
					<td>
						<input type="text" name="dtEntrada" /> 
					</td>
				</tr>
				
				<tr>
					<td>Exame Inicial:</td>
					<td>
						<input type="text" name="exameinicial" /> 
					</td>
					<tr>
					<td>Data de saida:</td>
					<td>
						<input type="text" name="dtSaida" /> 
					</td>
				</tr>
				
				<tr>
					<td>Medicamentos:</td>
					<td>
						<input type="text" name="medicamentos" /> 
					</td>
				</tr>
				
				<tr>
					<td>tratamentos:</td>
					<td>
						<input type="text" name="tratamentos" /> 
					</td>
				</tr>
				</table>
				</fieldset>
		<input type="submit" value="Cadastrar"/>
		<input type="reset" value="Limpar"/>
	</form>
</body>
</html>
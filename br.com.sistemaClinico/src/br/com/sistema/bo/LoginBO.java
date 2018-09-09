package br.com.sistema.bo;

import br.com.sistemaClinico.dao.LoginDAO;
import br.com.sistemaClinico.dto.LoginDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;

public class LoginBO {
	
	public boolean Logar(LoginDTO loginDTO) throws NegocioException {
		boolean logado = false;
		try {
			if(loginDTO.getLogin() == null ||"".equals(loginDTO.getLogin())) {
				throw new NegocioException("Login obrigatorio");
			}else if(loginDTO.getSenha()==null || "".equals(loginDTO.getSenha())) {
				throw new NegocioException("Senha obrigatoria");
				
			}else {
				LoginDAO loginDAO = new LoginDAO();
				logado = loginDAO.Logar(loginDTO);
			}
			
		}catch(Exception e) {
			
			throw new NegocioException(e.getMessage(),e);
		}
				
		return logado;
	}
	

}

package br.com.sistemaClinico.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistema.bo.LoginBO;
import br.com.sistemaClinico.dto.LoginDTO;
import br.edu.devmedia.jdbc.exception.NegocioException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBO loginBO = new LoginBO();
		String login = request.getParameter("login");
		String senha = request.getParameter("Senha");
		request.getSession();
		
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setLogin(login);
		loginDTO.setSenha(senha);
		String proximaPagina = "home.jsp";
		try {
			boolean resposta = loginBO.Logar(loginDTO);
			
			if(!resposta) {
				request.setAttribute("msg", "Usuario/Login invalido");
				proximaPagina = "index.jsp";
			}
			
		}catch(NegocioException e) {
			proximaPagina = "index.jsp";
			request.setAttribute("msg", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(proximaPagina);
		dispatcher.forward(request, response);
	}

}

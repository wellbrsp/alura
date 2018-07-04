package br.com.alura.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.dao.ContatoDao;
import br.com.alura.model.Contato;

public class CadastraContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String data = req.getParameter("dataNascimento");
		Date dataNascimento = null;
		
		try {
			if(data != null) {
				dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			}
		} catch (ParseException e) {
			pw.println("Erro na conversão da data");
			return;
		}
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(new Contato(nome, email, endereco, dataNascimento));
		
	}
}

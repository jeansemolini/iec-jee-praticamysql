package controller.produto;

import business.CategoriaService;
import business.ProdutoService;
import model.Categoria;
import model.Produto;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


/**
 * Servlet implementation class InserirProduto
 */
@WebServlet(urlPatterns = "/produto/listar")
public class ListarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ProdutoService service;
	@EJB
	private CategoriaService categoriaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String categoriaId = request.getParameter("categoria_id");
			String nome = request.getParameter("nome");

			if (categoriaId != null) {
				listaProdutoPorCategoria(request, response, Integer.parseInt(categoriaId));
			} else if (nome != null) {
				listaProdutoPorNome(request, response, nome);
			} else {
				listaProduto(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listaProdutoPorCategoria(HttpServletRequest request, HttpServletResponse response, Integer categoriaId)
			throws SQLException, IOException, ServletException {
		List<Produto> listaProduto = service.listarPorCategoria(categoriaId);
		request.setAttribute("listaProduto", listaProduto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
		dispatcher.forward(request, response);
	}

	private void listaProdutoPorNome(HttpServletRequest request, HttpServletResponse response, String nome)
			throws SQLException, IOException, ServletException {
		List<Produto> listaProduto = service.listarPorNome(nome);
		request.setAttribute("listaProduto", listaProduto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
		dispatcher.forward(request, response);
	}

	private void listaProduto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Produto> listaProduto = service.listar();
		request.setAttribute("listaProduto", listaProduto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
		dispatcher.forward(request, response);
	}


	private Categoria buscarCategoria(Integer codigo) {
		try {
			return categoriaService.porCodigo(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

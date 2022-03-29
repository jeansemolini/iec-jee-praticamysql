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
@WebServlet(urlPatterns = "/produto/inserir")
public class InserirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ProdutoService service;
	@EJB
	private CategoriaService categoriaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listaCategoria(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String preco = request.getParameter("preco");
		Integer codigoCategoria = Integer.valueOf(request.getParameter("categoria"));

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(Double.valueOf(preco));
		produto.setCategoria(buscarCategoria(codigoCategoria));

		try {
			service.inserir(produto);

			response.sendRedirect(request.getContextPath() + "/produto/listar");
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel inserir o produto!</h2>");
			out.print("<br");
			out.print("<a href = 'index.jsp'> Voltar </a>");
			out.print("</html>");
		}
	}

	private void listaCategoria(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Categoria> listaCategoria = categoriaService.listar();
		request.setAttribute("listaCategoria", listaCategoria);
		RequestDispatcher dispatcher = request.getRequestDispatcher("inserir.jsp");
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

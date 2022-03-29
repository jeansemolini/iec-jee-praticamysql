package repository;

import model.Produto;

import java.util.List;

public interface ProdutoRepository {
    void inserir(Produto produto);

    List<Produto> listar();

    List<Produto> listarPorCategoria(Integer categoriaId);

    List<Produto> listarPorNome(String nome);

    Produto porCodigo(Integer id) throws Exception;

    void editar(Produto produto) throws Exception;

    void deletar(Integer codigo) throws Exception;
}

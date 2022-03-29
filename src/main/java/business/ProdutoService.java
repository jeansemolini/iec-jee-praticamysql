package business;

import model.Categoria;
import model.Produto;
import repository.CategoriaRepository;
import repository.ProdutoRepository;
import repository.RepositorySession;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

@Stateless
public class ProdutoService {
    @EJB
    private RepositorySession repository;
    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void initialize() {
        produtoRepository = repository.getProdutoRepository();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inserir(Produto produto) {
        produtoRepository.inserir(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.listar();
    }

    public List<Produto> listarPorCategoria(Integer categoriaId) {
        return produtoRepository.listarPorCategoria(categoriaId);
    }

    public List<Produto> listarPorNome(String nome) {
        return produtoRepository.listarPorNome(nome);
    }

    public Produto porCodigo(Integer codigo) throws Exception {
        return produtoRepository.porCodigo(codigo);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void editar(Produto produto) throws Exception {
        produtoRepository.editar(produto);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deletar(Integer codigo) throws Exception {
        produtoRepository.deletar(codigo);
    } 

}

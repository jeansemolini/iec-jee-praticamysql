package repository.impl;

import model.Produto;
import repository.ProdutoRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private EntityManager em;

    public ProdutoRepository setEntityManager(EntityManager em) {
        this.em = em;
        return this;
    }
    @Override
    public void inserir(Produto produto) {
        em.persist(produto);
    }

    @Override
    public List<Produto> listar() {
        return em.createQuery("select p from Produto p", Produto.class)
            .getResultList();
    }
    @Override
    public List<Produto> listarPorCategoria(Integer categoriaId) {
        return em.createQuery("select p from Produto p where p.categoria.codigo = " + categoriaId, Produto.class)
                .getResultList();
    }
    @Override
    public List<Produto> listarPorNome(String nome) {
        return em.createQuery("select p from Produto p where p.nome like '%" + nome + "%'", Produto.class)
                .getResultList();
    }
    @Override
    public Produto porCodigo(Integer id) throws Exception {
        return em.find(Produto.class, id);
    }
    @Override
    public void editar(Produto produto) throws Exception {
        em.merge(produto);
    }
    @Override
    public void deletar(Integer codigo) throws Exception {
        var produto = em.find(Produto.class, codigo);
        em.remove(produto);
    }
}

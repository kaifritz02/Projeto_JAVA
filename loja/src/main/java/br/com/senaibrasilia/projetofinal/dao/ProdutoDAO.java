package br.com.senaibrasilia.projetofinal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;

public class ProdutoDAO {

	private EntityManager em;

	// Construtor vazio
	public ProdutoDAO() {

	}

	// Construtor por sobrecarga
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	// Cadastrar Produto (PERSIST)
	public void cadastrarP(Produto produto) {
		this.em.persist(produto);
	}

	// Atualizar informações do primeiro Cadastro (MERGE)
	public void atualizarP(Produto produto) {
		this.em.merge(produto);
	}

	// Remove os produtos
	public void removerP(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

	// Buscar produtos pelo o seu ID único
	public Produto buscarPorIdP(Long id) {
		return em.find(Produto.class, id);

	}

	// Buscar todos os produtos cadastrados
	public List<Produto> buscarTodosP() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();

	}

	public List<Produto> buscarPorNomeP(String nome) {

		// Variavel JPQL para executar ações no banco
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";

		// Variavel criada com jpql para procurar os produtos desejados
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}

	public List<Produto> buscarPorNomeDaCategoriaP(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();

	}
}

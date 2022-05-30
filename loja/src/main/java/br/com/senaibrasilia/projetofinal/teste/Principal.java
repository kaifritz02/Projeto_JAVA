package br.com.senaibrasilia.projetofinal.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.dao.CategoriaDAO;
import br.com.senaibrasilia.projetofinal.dao.ProdutoDAO;
import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class Principal {

	public static void main(String[] args) {

		cadastrarProduto();

		//EntityManager em = JPAUtil.getEntityManager();
		//ProdutoDao produtoDao = new ProdutoDao(em);

//		Produto p = produtoDao.buscarPorId(1l);
//		System.out.println(p.getPreco());

//		List<Produto> todos = produtoDao.buscarPorNome("frutas");
//		todos.forEach(p2 -> System.out.println(p.getNome()));

//		List<Produto> precoDoProduto = produtoDao.buscarPorNome("Xiaomi Note 10 Pro");
//		System.out.println("Preço do Produto: " + precoDoProduto);

	}

	private static void cadastrarProduto() {
		
		Categoria frutas = new Categoria("FRUTAS");
		Produto fruta = new Produto("Maçã", "Madura",
				new BigDecimal("5"), frutas);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

	//	categoriaDAO.cadastrar(frutas);
	//	produtoDAO.cadastrar();
		em.persist(fruta);
		em.persist(frutas);
		em.getTransaction().commit();
		em.close();
	}
}

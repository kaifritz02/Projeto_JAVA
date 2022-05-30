package br.com.senaibrasilia.projetofinal.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class CategoriaDAO {

		
		private EntityManager em;
		
		//======================================================

		public CategoriaDAO(EntityManager em) {
			super();
			this.em = em;
		}

		//Persiste ou insere uma nova categoria.
		public void cadastrarC(Categoria categoria) {
			//persist
			this.em.persist(categoria);
		}
		
		//Altera (merge) alguma categoria.
		public void alterarC(Categoria categoria) {
			// merge
			this.em.merge(categoria);
			
		}
		
		//Remove alguma categoria
		public void removeC(Categoria categoria) {
			//remove
			this.em.remove(categoria);
			
		}
		
		//Procura algum produto pelo o seu ID.
		public Categoria pesquisarPorIdC(Long id) {
			//find
			return em.find(Categoria.class, id);
			
		}
		
		// Lista todas as categorias disponíveis
		public List<Categoria> pesquisarTodosC() {
			// query - JPQL
			//Arraylist - List
			//lambda
			String todosc= "SELECT categ FROM Categoria categ";
			return em.createQuery(todosc, Categoria.class).getResultList();
			
		}
		
		// Faz a listagem por nome.
		public List<Categoria> buscarPorNomeDaCategoria(String nome) {
			String jpql = "SELECT p FROM Categoria p WHERE p.categoria.nome :nome";
			return em.createQuery(jpql, Categoria.class).setParameter("nome", nome).getResultList();
					
		}

	}
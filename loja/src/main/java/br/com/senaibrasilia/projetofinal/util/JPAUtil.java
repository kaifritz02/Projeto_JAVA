package br.com.senaibrasilia.projetofinal.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (FACTORY == null) {
			Persistence.createEntityManagerFactory("loja");
		}
		return FACTORY;
	}

	public static void fechar() {
		if (FACTORY != null) {
			FACTORY.close();
		}
	}

}

package ma.ensaf.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoUtils {

	public static EntityManager createEntityManager() {
		return createEntityManagerFactory().createEntityManager();
	}

	private static EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("JpaPU");
	}
	
	public static String makeCriteria(String criteria) {
		if (criteria == null) return null;
		return "%" + criteria.toUpperCase() + "%";
	}
}

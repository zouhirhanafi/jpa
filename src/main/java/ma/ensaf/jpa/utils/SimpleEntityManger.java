package ma.ensaf.jpa.utils;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import lombok.Getter;

@Getter
public class SimpleEntityManger {
	
	private static SimpleEntityManger instance = new SimpleEntityManger();
	
	private EntityManager entityManager = DaoUtils.createEntityManager();

	private SimpleEntityManger() {}
	
	public static SimpleEntityManger getInstance() {
		return instance;
	}

	public void inTransaction(Consumer<?> traitement) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		traitement.accept(null);
		transaction.commit();
	}
}

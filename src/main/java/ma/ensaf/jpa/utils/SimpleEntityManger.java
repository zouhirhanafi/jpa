package ma.ensaf.jpa.utils;

import javax.persistence.EntityManager;

import lombok.Getter;

@Getter
public class SimpleEntityManger {
	
	private static SimpleEntityManger instance = new SimpleEntityManger();
	
	private EntityManager entityManager = DaoUtils.createEntityManager();

	private SimpleEntityManger() {}
	
	public static SimpleEntityManger getInstance() {
		return instance;
	}

}

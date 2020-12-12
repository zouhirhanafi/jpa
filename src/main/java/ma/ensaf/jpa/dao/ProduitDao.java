package ma.ensaf.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ma.ensaf.jpa.entity.Produit;
import ma.ensaf.jpa.utils.DaoUtils;

public class ProduitDao {
	
	private EntityManager entityManager;

	public ProduitDao() {
		entityManager = DaoUtils.createEntityManager();
	}
	
	public Produit create(Produit p) {
		entityManager.getTransaction().begin();
		entityManager.persist(p);
		entityManager.getTransaction().commit();
		return p;
	}

	public Produit update(Produit p) {
		entityManager.getTransaction().begin();
		entityManager.merge(p);
		entityManager.getTransaction().commit();
		return p;
	}

	public void delete(Produit produit) {
		entityManager.getTransaction().begin();
		entityManager.remove(produit);
		entityManager.getTransaction().commit();
	}

	public void delete(Long id) {
		Produit produit = findOne(id);
		delete(produit);
	}
	
	public Produit findOne(Long id) {
		entityManager.getTransaction().begin();
		Produit produit = entityManager.find(Produit.class, id);
		entityManager.getTransaction().commit();
		return produit;
	}
	
	public List<Produit> findAll() {
		entityManager.getTransaction().begin();
		List<Produit> list = entityManager.createQuery("from Produit").getResultList();
		entityManager.getTransaction().commit();
		return list;
		
	}
}

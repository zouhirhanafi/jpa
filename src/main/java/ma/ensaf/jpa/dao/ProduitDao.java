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
		entityManager.persist(p);
		return p;
	}

	public Produit update(Produit p) {
		// creation de l'entité si la clé primaire est null, sinon il met a jour les informations
		entityManager.merge(p);
		return p;
	}

	public void delete(Produit produit) {
		entityManager.remove(produit);
	}

	public void delete(Long id) {
		Produit produit = findOne(id);
		delete(produit);
	}
	
	public Produit findOne(Long id) {
		Produit produit = entityManager.find(Produit.class, id);
		return produit;
	}
	
	public List<Produit> findAll() {
		List<Produit> list = entityManager.createQuery("from Produit").getResultList();
		return list;
	}
}

package ma.ensaf.jpa.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	public List<?> findList(String queryString, Map<String, Object> parameters) {
		Query query = createQuery(queryString);
		if (parameters != null) {
			parameters.forEach((key, value) -> {
				query.setParameter(key, value);
			});
		}
		return query.getResultList();
	}
	
	public Produit findByReference(String reference) {
		Query query = createQuery("from Produit where reference = :ref");
		query.setParameter("ref", reference);
		List<Produit> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public Produit findByCodeBarre(String codeBarre) {
		Query query = createQuery("from Produit where codeBarre = ?0");
		query.setParameter(0, codeBarre);
		List<Produit> list = query.getResultList();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public List<Produit> findAll() {
		List<Produit> list = entityManager.createQuery("from Produit").getResultList();
		return list;
	}
	
	public Query createQuery(String query) {
		return entityManager.createQuery(query);
	}
}

package ma.ensaf.jpa.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import ma.ensaf.jpa.dao.ProduitDao;
import ma.ensaf.jpa.dto.ProduitDto;
import ma.ensaf.jpa.entity.Produit;
import ma.ensaf.jpa.utils.DaoUtils;
import ma.ensaf.jpa.utils.SimpleEntityManger;
import ma.ensaf.jpa.utils.UtilDateTime;

public class JpqlMain {
	private ProduitDao produitDao = new ProduitDao();
	
	private SimpleEntityManger instance = SimpleEntityManger.getInstance();
	
	void afficherProduit(Produit p) {
		System.out.println(p);
	}
	
	void afficherProduit(List<?> produits) {
		produits.forEach(produit -> {
			System.out.println(produit);
		});
	}

	void ex01() {
		System.out.println("=============== ex 01 ===========");
		instance.inTransaction(obj -> {
			/* getSingleResult : retourne un seul element
			 * javax.persistence.NoResultException : aucun résultat
			 * javax.persistence.NonUniqueResultException : count > 1
			 */
			Produit produit = (Produit) produitDao.createQuery("from Produit where reference like 'c%'").getSingleResult();
			afficherProduit(produit);
		});
	}
	
	void ex02() {
		System.out.println("=============== ex 02 ===========");
		instance.inTransaction(obj -> {
			/* getResultList : retourne le résultat de la req sous format d'une liste
			 */
			Query query = produitDao.createQuery("from Produit where reference like 'c%'");
			List<Produit> produits = query.getResultList();
			afficherProduit(produits);
		});
	}
	
	void ex03() {
		System.out.println("=============== ex 03 : récupérer un produit par sa reference ===========");
		instance.inTransaction(obj -> {
			Produit p;
			p = produitDao.findByReference("c1");
			System.out.println(p);
			p = produitDao.findByReference("c10");
			System.out.println(p);
		});
	}
	
	void ex04() {
		System.out.println("=============== ex 04 : récupérer un produit par son code barre ===========");
		instance.inTransaction(obj -> {
			Produit p;
			p = produitDao.findByCodeBarre("121234");
			System.out.println(p);
		});
	}
	
	void ex05() {
		System.out.println("=============== ex 05 ===========");
		instance.inTransaction(obj -> {
			
			String queryString = "from Produit where upper(designation) like :desig and pu > :pu";
			
			Map<String, Object> params = new HashMap<>();
			params.put("desig", DaoUtils.makeCriteria("clavier"));
			params.put("pu", 20);
			List<Produit> produits = (List<Produit>) produitDao.findList(queryString , params);
			afficherProduit(produits);
		});
	}
	
	void ex06() {
		System.out.println("=============== ex 06 : recherche par date ===========");
		instance.inTransaction(obj -> {
			
			String queryString = "FROM Produit WHERE dateCreation BETWEEN :start AND :end";

			Map<String, Object> params = new HashMap<>();
			params.put("start", UtilDateTime.toInstant("2020-12-01"));
			params.put("end", UtilDateTime.toInstant("2020-12-25"));
			List<Produit> produits = (List<Produit>) produitDao.findList(queryString , params);
			afficherProduit(produits);
		});
	}
	
	void ex07() {
		System.out.println("=============== ex 07 : projection ===========");
		instance.inTransaction(obj -> {
			
			String queryString = "SELECT new ma.ensaf.jpa.dto.ProduitDto(id, reference, pu) FROM Produit";
			List<ProduitDto> produits = (List<ProduitDto>) produitDao.findList(queryString , null);
			afficherProduit(produits);
		});
	}
	
	public JpqlMain() {
		ex07();
//		ex06();
//		ex05();
//		ex04();
//		ex03();
//		ex02();
//		ex01();
	}

	public static void main(String[] args) {
		new JpqlMain();
	}

}

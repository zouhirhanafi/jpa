/**
 * 
 */
package ma.ensaf.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import ma.ensaf.jpa.dao.ProduitDao;
import ma.ensaf.jpa.entity.Client;
import ma.ensaf.jpa.entity.Produit;
import ma.ensaf.jpa.utils.DaoUtils;

/**
 * @author zhi
 *
 */
@Slf4j
public class Main {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	private ProduitDao produitDao = new ProduitDao();
	
    protected void ex01() {
    	log.info("=== exemple 1 ===");
    	@Cleanup EntityManager entityManager = DaoUtils.createEntityManager();
        EntityTransaction txn = null;
        txn = entityManager.getTransaction();
        // debut de la transaction
        txn.begin();
        // les operations de crud
        Client c = Client.builder().name("zouhir HANAFI").build();
        entityManager.persist(c);
        // fin de la trancation
        txn.commit();
    }
	
    protected void ex02() {
    	log.info("=== exemple 2 ===");
    	@Cleanup EntityManager entityManager = DaoUtils.createEntityManager();
    	EntityTransaction txn = null;
    	txn = entityManager.getTransaction();
    	// debut de la transaction
    	txn.begin();
    	// les operations de crud
    	Produit p = Produit.builder().designation("clavier").pu(40).reference("c01").build();
    	entityManager.persist(p);
    	// fin de la trancation
    	txn.commit();
    }
    
    protected void ex03() {
    	// les operations de crud
    	Produit p = Produit.builder().designation("souris").pu(30).reference("s01").build();
    	produitDao.create(p);
    	listerLesProduits();
    }
    
    protected void listerLesProduits(List<Produit> list) {
    	for (Produit produit : list) {
    		log.info("produit : {}", produit);
    	}
    }
    protected void listerLesProduits() {
    	List<Produit> list = produitDao.findAll();
    	listerLesProduits(list);
    }

    protected void ex04() {
    	Produit produit = produitDao.findOne(3l);
    	produit.setPu(45);
    	produit.setCodeBarre("s019292");
    	produitDao.update(produit);
    	listerLesProduits();
    }
    
    protected void ex05() {
    	listerLesProduits();
    	produitDao.delete(2l);
    	listerLesProduits();
    }
    

    protected void ex06() {
    	listerLesProduits();

    	@Cleanup EntityManager entityManager = DaoUtils.createEntityManager();
    	EntityTransaction txn = null;
    	txn = entityManager.getTransaction();
    	// debut de la transaction
    	txn.begin();
    	Produit produit = entityManager.find(Produit.class, 3l);
    	produit.setUnite("U");
    	produit.setPu(41);
    	produit.setCodeBarre("3498");
    	// fin de la trancation
    	entityManager.flush();
    	List<Produit> list = entityManager.createQuery("from Produit").getResultList();
    	listerLesProduits(list);
    	txn.commit();
    	
    }

    
	public Main() {
//		ex01();
//		ex02();
//		ex03();
//		ex04();
//		ex05();
		ex06();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}

}

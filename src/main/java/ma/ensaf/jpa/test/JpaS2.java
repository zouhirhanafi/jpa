package ma.ensaf.jpa.test;

import javax.persistence.EntityManager;

import ma.ensaf.jpa.dao.ClientDao;
import ma.ensaf.jpa.dao.CommandeDao;
import ma.ensaf.jpa.dao.LigneCommandeDao;
import ma.ensaf.jpa.entity.Client;
import ma.ensaf.jpa.entity.Commande;
import ma.ensaf.jpa.entity.LigneCommande;
import ma.ensaf.jpa.entity.Produit;
import ma.ensaf.jpa.utils.SimpleEntityManger;

public class JpaS2 {
	
	private EntityManager entityManager = SimpleEntityManger.getInstance().getEntityManager();
	
	private CommandeDao commandeDao = new CommandeDao();
	ClientDao clientDao = new ClientDao();
	LigneCommandeDao ligneCommandeDao = new LigneCommandeDao();

	void ex01() {
		entityManager.getTransaction().begin();
		Client c = Client.builder().name("hamid").build();
		clientDao.create(c);
		entityManager.getTransaction().commit();
	}
	
	void ex02() {
		Client client = Client.builder().id(9l).build();
		entityManager.getTransaction().begin();
		Commande c = Commande.builder().client(client).build();
		commandeDao.create(c);
		
		LigneCommande l1 = LigneCommande.builder().produit(Produit.builder().id(2l).build()).commande(c).quantite(2).build();
		ligneCommandeDao.create(l1);
		LigneCommande l2 = LigneCommande.builder().produit(Produit.builder().id(4l).build()).commande(c).quantite(3).build();
		ligneCommandeDao.create(l2);
		entityManager.getTransaction().commit();
	}

	void ex03() {
		entityManager.getTransaction().begin();
		Commande commande = commandeDao.findOne(16L);
		entityManager.getTransaction().commit();
		//TODO voir proble eager & lazy
		// ui
		System.out.println("ref commande : " + commande.getId());
		System.out.println("nom client : " + commande.getClient().getName());
	}


	public JpaS2() {
//		ex01();
//		ex02();
		ex03();
	}

	public static void main(String[] args) {
		new JpaS2();
	}

}

package ma.ensaf.jpa.test;

import javax.persistence.EntityManager;

import ma.ensaf.jpa.dao.ClientDao;
import ma.ensaf.jpa.dao.CommandeDao;
import ma.ensaf.jpa.dao.LigneCommandeDao;
import ma.ensaf.jpa.entity.Adresse;
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

	void ex04() {
		// exemple d'ajout d'une commande avec ses lignes
		Client client = Client.builder().id(8l).build();


		LigneCommande l1 = LigneCommande.builder().produit(Produit.builder().id(2l).build()).quantite(2).build();
		LigneCommande l2 = LigneCommande.builder().produit(Produit.builder().id(4l).build()).quantite(3).build();
		
		Commande commande = Commande.builder().client(client).build();
		commande.addLigne(l1);
		commande.addLigne(l2);
		commande.addLigne(LigneCommande.builder().produit(Produit.builder().id(4l).build()).quantite(5).build());
		
		entityManager.getTransaction().begin();
		commandeDao.create(commande);
		System.out.println("======= Commande " + commande.getId() + " créé avec sucès");
		entityManager.getTransaction().commit();
	}

	void ex05() {
		// exemple de modification d'une commande
		Commande commande = getCommande(37L);
		entityManager.getTransaction().begin();
		commande.setCodePromotion("3131");
		commande.addLigne(LigneCommande.builder().produit(Produit.builder().id(2l).build()).quantite(10).build());
		commandeDao.update(commande);
		entityManager.getTransaction().commit();
	}
	
	void ex06() {
		// exemple de suppression d'une commande
		entityManager.getTransaction().begin();
		commandeDao.delete(37L);
		entityManager.getTransaction().commit();
	}
	
	void ex07() {
		// exemple de suppression d'une ligne commande d'une commande x
		Commande commande = getCommande(48L);
		System.out.println("Avant suppression - nombre des lignes :  " + commande.getLignes().size());
		commande.deleteLigne(50L);
		System.out.println("Apres suppression - nombre des lignes :  " + commande.getLignes().size());
		entityManager.getTransaction().begin();
		commandeDao.update(commande);
		entityManager.getTransaction().commit();
	}
	
	void ex08() {
		// exemple one to one
		entityManager.getTransaction().begin();
		Adresse adresse = Adresse.builder().codePostal("30000").ville("Fes").build();
		Client client = Client.builder().name("alae").adresse(adresse).build();
		client = clientDao.create(client);
		entityManager.getTransaction().commit();
		System.out.println("client " + client.getId() + " créé avec succès");
	}
	
	Commande getCommande(Long id) {
		entityManager.getTransaction().begin();
		Commande commande = commandeDao.findOne(id);
		entityManager.getTransaction().commit();
		return commande;
	}

	public JpaS2() {
//		ex01();
//		ex02();
//		ex03();
//		ex04();
//		ex05();
//		ex06();
//		ex07();
		ex08();
	}

	public static void main(String[] args) {
		new JpaS2();
	}

}

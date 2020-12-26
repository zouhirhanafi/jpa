package ma.ensaf.jpa.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.ensaf.jpa.entity.Client;
import ma.ensaf.jpa.entity.Commande;

public class Spring01 {
	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml"); 
	
	void afficherClient(Client client) {
		System.out.println(client.getName() + ", Ville : " + client.getAdresse().getVille());
	}
	
	void exp01() {
		Client client1 = context.getBean("c01", Client.class);
		Client client2 = context.getBean("c02", Client.class);
		Client client3 = context.getBean("c03", Client.class);
		afficherClient(client3);
		afficherClient(client1);
		afficherClient(client2);
		client2.getAdresse().setVille("Rabat");
		afficherClient(client1);
		afficherClient(client2);
	}
	
	void exp02() {
		Commande commande = context.getBean("cmd01", Commande.class);
		afficherCommande(commande);
	}
	
	private void afficherCommande(Commande commande) {
		System.out.println("ref commande : " + commande.getId());
		afficherClient(commande.getClient());
		commande.getLignes().forEach(System.out::println);
	}

	public Spring01() {
//		exp01();
		exp02();
	}

	public static void main(String[] args) {
		new Spring01();
	}

}

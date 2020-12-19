package ma.ensaf.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter @Setter

@Entity
public class LigneCommande {
	@Id @GeneratedValue
	private Long id;
	private int quantite;
	
	@ManyToOne
	private Commande commande;
	@ManyToOne
	private Produit produit;
	
}

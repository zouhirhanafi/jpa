package ma.ensaf.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ma.ensaf.jpa.dao.utils.PersistentEntity;


@Builder
@Getter @Setter
@RequiredArgsConstructor @AllArgsConstructor

@Entity
public class LigneCommande extends PersistentEntity {
	private int quantite;
	
	@ManyToOne
	private Commande commande;
	@ManyToOne
	private Produit produit;
	
	
	public static LigneCommande of(Long id) {
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setId(id);
		return ligneCommande;
	}
}

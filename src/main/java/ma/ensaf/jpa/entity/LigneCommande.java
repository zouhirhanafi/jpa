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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LigneCommande [quantite=");
		builder.append(quantite);
		builder.append(", id=");
		builder.append(getId());
		builder.append(", produit=");
		builder.append(produit);
		builder.append("]");
		return builder.toString();
	}
	
}

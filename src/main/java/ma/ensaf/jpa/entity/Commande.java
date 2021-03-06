package ma.ensaf.jpa.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor @AllArgsConstructor

@Getter @Setter
@Entity
public class Commande {
	@Id @GeneratedValue
	private Long id;
	
	@Builder.Default
	@Column(nullable = false, updatable = false)
	private Instant dateCreation = Instant.now();
	
	private String codePromotion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;
	
	@Builder.Default // LOMBOK initialisation de la liste
	@OneToMany(mappedBy = "commande", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true )
	private List<LigneCommande> lignes = new ArrayList<LigneCommande>();
	
	
	public void addLigne(LigneCommande ligneCommande) {
		ligneCommande.setCommande(this);
		this.lignes.add(ligneCommande);
	}
	
	public void deleteLigne(Long idLigneCommande) {
		this.lignes.remove(LigneCommande.of(idLigneCommande));
	}
}

package ma.ensaf.jpa.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.ensaf.jpa.dao.utils.PersistentEntity;


@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
public class Adresse extends PersistentEntity {
	private String pays;
	private String ville;
	private String ligne1;
	private String ligne2;
	private String codePostal;
	
}

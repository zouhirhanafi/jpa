package ma.ensaf.jpa.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Client client;

}

package ma.ensaf.jpa.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// JPA
@Entity
@Table(name = "jpa_produit")
// lombok
@EqualsAndHashCode(of = "id")
@Getter @Setter
@RequiredArgsConstructor @AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Produit {
	
	@Id @GeneratedValue
	private Long id;
	
	@Builder.Default
	@Column(nullable = false, updatable = false)
	private Instant dateCreation = Instant.now();

	@Column(unique = true, nullable = false, length = 20, name = "ref")
	private String reference;
	
	@Column(nullable = false, length = 500)
	private String designation;
	
	@Column(name = "prix_unitaire")
	private Integer pu;
	
	private String unite;
	
	@Column(length = 100)
	private String image;
	
	private String codeBarre;
	
	
//	public Produit(Long id) {
//		this.id = id;
//	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDesignation() {
//		return designation;
//	}
//
//	public void setDesignation(String designation) {
//		this.designation = designation;
//	}
//
//	public Integer getPu() {
//		return pu;
//	}
//
//	public void setPu(Integer pu) {
//		this.pu = pu;
//	}
//
//	public String getUnite() {
//		return unite;
//	}
//
//	public void setUnite(String unite) {
//		this.unite = unite;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Produit other = (Produit) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
	
	

}

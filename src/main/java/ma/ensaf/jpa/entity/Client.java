package ma.ensaf.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//lombok : https://projectlombok.org/features/all
//https://stackoverflow.com/questions/34241718/lombok-builder-and-jpa-default-constructor
//https://vladmihalcea.com/the-best-way-to-implement-equals-hashcode-and-tostring-with-jpa-and-hibernate/
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor()
@Setter
@Getter
public class Client {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof Client))
			return false;

		Client other = (Client) o;

		return id != null && id.equals(other.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}

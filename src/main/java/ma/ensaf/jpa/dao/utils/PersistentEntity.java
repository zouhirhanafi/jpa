package ma.ensaf.jpa.dao.utils;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(of = "id")

@MappedSuperclass
public class PersistentEntity {

	@Id @GeneratedValue
	private Long id;
}

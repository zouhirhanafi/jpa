package ma.ensaf.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProduitDto {

	private Long id;
	
	private String reference;
	
	private Integer pu;
}

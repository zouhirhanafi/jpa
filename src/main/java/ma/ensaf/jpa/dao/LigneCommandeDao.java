package ma.ensaf.jpa.dao;

import ma.ensaf.jpa.dao.utils.GenericDao;
import ma.ensaf.jpa.entity.LigneCommande;

public class LigneCommandeDao extends GenericDao<LigneCommande> {

	@Override
	protected Class<LigneCommande> getClazz() {
		return LigneCommande.class;
	}
	
}

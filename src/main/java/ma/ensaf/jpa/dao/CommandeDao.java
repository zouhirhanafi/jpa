package ma.ensaf.jpa.dao;

import ma.ensaf.jpa.dao.utils.GenericDao;
import ma.ensaf.jpa.entity.Commande;

public class CommandeDao extends GenericDao<Commande> {

	@Override
	protected Class<Commande> getClazz() {
		return Commande.class;
	}

}

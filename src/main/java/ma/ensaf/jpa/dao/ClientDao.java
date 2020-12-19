package ma.ensaf.jpa.dao;

import ma.ensaf.jpa.dao.utils.GenericDao;
import ma.ensaf.jpa.entity.Client;

public class ClientDao extends GenericDao<Client> {

	@Override
	protected Class<Client> getClazz() {
		return Client.class;
	}

}

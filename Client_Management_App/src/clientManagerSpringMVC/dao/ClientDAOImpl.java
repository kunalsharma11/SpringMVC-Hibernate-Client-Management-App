package clientManagerSpringMVC.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import clientManagerSpringMVC.entity.Client;

//Repository always applies to DAO, handles the exceptional translation of jdbc
@Repository
public class ClientDAOImpl implements ClientDAO {

	// add session factory from config file to this implementation
	@Autowired
	private SessionFactory sessionFactory;

	// using transactional handles begining/closing transaction automatically

	@Override
	public List<Client> getClients() {

		Session currentSession = sessionFactory.getCurrentSession();
		// System.out.println("inside clientDao");
		Query<Client> query = currentSession.createQuery("from Client order by firstName", Client.class);
		List<Client> clients = query.getResultList();

		return clients;
	}

	@Override
	public void addClient(Client client) {
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save or update client... hibernate method
		currentSession.saveOrUpdate(client);
	}

	@Override
	public Client getClient(int clientId) {

		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// retrieve client info from db using client id
		Client client = currentSession.get(Client.class, clientId);

		return client;
	}

	@Override
	public void removeClient(int clientId) {
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create query using client id and delete it
		Query query = currentSession.createQuery("delete from Client where id=:clientId");
		query.setParameter("clientId", clientId);
		query.executeUpdate();
	}

	@Override
	public List<Client> searchClient(String clientName) {
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create query for based on client name which may be first or last name

		Query query = null; // Query can be null, check for a valid query

		if (clientName != null && clientName.trim().length() > 0) {
			query = currentSession.createQuery(
					"from Client where lower(firstName) like :searchName or lower(lastName) like :searchName",
					Client.class);

			query.setParameter("searchName", "%" + clientName.toLowerCase() + "%");
		} else {
			query = currentSession.createQuery("from Client", Client.class);
		}
		List<Client> clientList = query.getResultList();

		return clientList;

	}

}

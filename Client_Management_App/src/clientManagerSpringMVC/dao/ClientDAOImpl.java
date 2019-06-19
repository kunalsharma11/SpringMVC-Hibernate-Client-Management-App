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

	//add session factory from config file to this implementation
	@Autowired
	private SessionFactory sessionFactory;
	
	//using transactional handles begining/closing transaction automatically
	
	@Override
	public List<Client> getClients() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("inside clientDao");
		Query<Client> query = currentSession.createQuery("from Client", Client.class);
		List<Client> clients = query.getResultList();
		
		
		return clients;
	}

}

package clientManagerSpringMVC.dao;

import java.util.List;

import clientManagerSpringMVC.entity.Client;

public interface ClientDAO {
	
	public List<Client> getClients();
	
}

package clientManagerSpringMVC.service;

import java.util.List;

import clientManagerSpringMVC.entity.Client;

public interface ClientService {
	
	public List<Client> getClients();
	
	public void addClient(Client client);

	public Client getClient(int clientId);
}

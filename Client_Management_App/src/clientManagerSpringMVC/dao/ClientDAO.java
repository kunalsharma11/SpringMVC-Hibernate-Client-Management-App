package clientManagerSpringMVC.dao;

import java.util.List;

import clientManagerSpringMVC.entity.Client;

public interface ClientDAO {

	public List<Client> getClients();

	public void addClient(Client client);

	public Client getClient(int clientId);

	public void removeClient(int clientId);

	public List<Client> searchClient(String clientName);

}

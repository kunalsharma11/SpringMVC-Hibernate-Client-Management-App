package clientManagerSpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clientManagerSpringMVC.dao.ClientDAO;
import clientManagerSpringMVC.entity.Client;
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return null;
	}

}

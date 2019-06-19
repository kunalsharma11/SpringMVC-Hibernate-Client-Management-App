package clientManagerSpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clientManagerSpringMVC.dao.ClientDAO;
import clientManagerSpringMVC.entity.Client;
import clientManagerSpringMVC.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	// use this in service layer
	// add client data access object(dao) here to connect client with clientdao
//	@Autowired
//	private ClientDAO clientDAO;

	@Autowired
	private ClientService clientService;

	@GetMapping("/list") // new annotation for get request
	public String listClients(Model model) {

		List<Client> clients = clientService.getClients(); // getting clients from service instead of DAO directly

		model.addAttribute("client_Records", clients);

		return "clientsList";
	}
}

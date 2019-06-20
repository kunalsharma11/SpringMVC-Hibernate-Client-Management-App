package clientManagerSpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);
		return "addClientForm";
	}
	
	@PostMapping("/addClient")
	public String addClient(@ModelAttribute("client") Client client) {
		
		clientService.addClient(client);
		
		return "redirect:/client/list";
	}
	
	@GetMapping("/editClientInfo")
	public String editClientInfo(@RequestParam("clientId") int clientId, Model model) {
		
		//get client from service layer
		Client client = clientService.getClient(clientId);
		
		//set client as a model attribute to pre-populate the form
		model.addAttribute("client", client);
		
		//send over to the form
		
		return "editClientInfoForm";
	}
	
	
	
}

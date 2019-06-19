package clientManagerSpringMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import clientManagerSpringMVC.dao.ClientDAO;
import clientManagerSpringMVC.entity.Client;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	//add client data access object(dao) here to connect client with clientdao
	@Autowired
	private ClientDAO clientDAO;
	
	@GetMapping("/list")			//new annotation for get request
	public String listClients(Model model) {
		
		List<Client> clients = clientDAO.getClients();
		
		model.addAttribute("client_Records",clients);
				
		return "clientsList";
	}
}

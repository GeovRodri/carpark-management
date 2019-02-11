package br.com.geovanyrodrigues.controller;

import br.com.geovanyrodrigues.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/api/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable("id") Integer id) {
		this.clientRepository.remove(id);
	}
}
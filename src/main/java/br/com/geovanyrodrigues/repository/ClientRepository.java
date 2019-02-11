package br.com.geovanyrodrigues.repository;

import br.com.geovanyrodrigues.common.GenericRepository;
import br.com.geovanyrodrigues.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository extends GenericRepository<Client, Integer> {

    public ClientRepository() {
        super(Client.class);
    }


}

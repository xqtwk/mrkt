package lt.ku.hotel.services;

import lt.ku.hotel.entities.Client;
import lt.ku.hotel.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client){
        client.setPassword((new BCryptPasswordEncoder()).encode(client.getPassword()));
        return clientRepository.save(client);
    }
    /*public Client updateClients(Client client){
        Client old = clientRepository.getById(client.getId());
        old.setName(client.getName());
        old.setSurname(client.getSurname());
        old.setEmail(client.getEmail());
        old.setPhone(client.getPhone());
        clientRepository.save(old);
        return old;
    }*/
    public void deleteClients( Integer id){
        clientRepository.deleteById(id);
    }
    public Client getClients(Integer id){
        return clientRepository.getById(id);
    }
    public List<Client> getAllClients() { return clientRepository.findAll(); }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);
        if (client==null) {
            throw new UsernameNotFoundException("Vartotojas nerastas");
        }
        return client;
    }
}

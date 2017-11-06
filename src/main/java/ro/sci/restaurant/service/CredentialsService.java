package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Credentials;
import ro.sci.restaurant.repository.CredentialRepository;

import java.util.List;


@Service
public class CredentialsService {
    @Autowired
    private CredentialRepository credentialRepository;

    public List<Credentials> getAll() {
        return credentialRepository.findAll();
    }

    public boolean add(Credentials credential) {
        for (Credentials cre : credentialRepository.findAll()) {
            if (cre.getPassword().equals(credential.getPassword()) || cre.getUsername().equals(credential.getUsername())) {
                return false;
            }
        }
        credentialRepository.save(credential);
        return true;
    }

    public Credentials getByUid(int uid) {
        return credentialRepository.findOne(uid);
    }

    public void remove(Credentials credential) {
        credentialRepository.delete(credential);
    }

    public Credentials getByUsername(String username) {
        return credentialRepository.findByUsername(username);
    }

    public void update(Credentials credentials) {
        Credentials cre = credentialRepository.findOne(credentials.getUid());
        cre.setPassword(credentials.getPassword());
        cre.setUsername(credentials.getUsername());
        cre.setRole(credentials.getRole());
        cre.setUid(credentials.getUid());
        credentialRepository.save(cre);
    }

}

package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Credentials;
import ro.sci.restaurant.repository.CredentialRepository;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class CredentialsService {
    @Autowired
    private CredentialRepository credentialRepository;

//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    public Credentials getByUid(int uid) {
//        return credentialRepository.findByUid(uid);
//    }

    public List<Credentials> getAll() {
        List<Credentials> credentials = new ArrayList<>();
        credentialRepository.findAll().forEach(credentials::add);
        return credentials;
    }

    public boolean add(Credentials credential) {
            for(Credentials cre : credentialRepository.findAll())
            {
                if(cre.getUsername().equals(credential.getPassword()) || cre.getUsername().equals(credential.getUsername()))
                {
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

}

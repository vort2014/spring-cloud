package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRest {

    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/create")
    public ClientEntity create(@RequestParam String name) {
        return clientDAO.create(name);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestParam String name) {
        if (clientDAO.update(id, name)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        clientRepository.delete(id);
    }

    @GetMapping("/get")
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ClientEntity findOne(@PathVariable Integer id) {
        return clientRepository.findOne(id);
    }
}

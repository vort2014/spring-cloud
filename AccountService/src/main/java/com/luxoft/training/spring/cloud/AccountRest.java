package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountRest {

    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/create")
    public void create(@RequestParam Integer clientId) {
        accountDAO.create(clientId);
    }

    @GetMapping("/fund/{id}")
    public boolean fund(@PathVariable Integer id, @RequestParam BigDecimal sum) {
        return accountDAO.addBalance(id, sum.abs());
    }

    @GetMapping("/checkout/{id}")
    public boolean checkout(@PathVariable Integer id, @RequestParam BigDecimal sum) {
        return accountDAO.addBalance(id, sum.abs().negate());
    }

    @GetMapping("/get/{clientId}")
    public List<AccountEntity> get(@PathVariable Integer clientId) {
        return accountRepository.findByClientId(clientId);
    }
}

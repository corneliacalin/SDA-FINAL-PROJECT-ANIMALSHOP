package com.corneliacalin.sda.onlineanimalshop.service;

import com.corneliacalin.sda.onlineanimalshop.model.Account;
import com.corneliacalin.sda.onlineanimalshop.model.Role;
import com.corneliacalin.sda.onlineanimalshop.repository.AccountRepository;
import com.corneliacalin.sda.onlineanimalshop.service.dto.AccountDTO;
import com.corneliacalin.sda.onlineanimalshop.service.mail.MailService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Collection;
import java.util.Collections;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final MailService mailService;
    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder passwordEncoder, MailService mailService) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new User(account.getEmail(), account.getPassword(), mapRolesToAuthorities(account.getRole()));
    }


// pentru roluri
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role)
    {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }



    public void createAccount(AccountDTO accountDTO) {


        Account account = new Account();
        account.setEmail(accountDTO.getEmail());
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));

        account.setRole(Role.USER);
        accountRepository.save(account);
//trimite e-mail de inregistrare -functioneaza dar l-am oprit
        //try {
//            mailService.sendMail("office@animalshop.ro", accountDTO.getEmail(),"new account on animalshop", "Registered succesfully on animalshop ");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }


    }
    public Boolean accountExist(String email) {
        Account accountExisting = accountRepository.findByEmail(email);
        return accountExisting != null;
    }


}
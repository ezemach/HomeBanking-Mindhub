package com.mindhub.homebanking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String firstName;
    private String lastName;

    private String email;


    @OneToMany(mappedBy="owner", fetch=FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy="owner", fetch=FetchType.EAGER)
    private Set<ClientLoan> clientLoans = new HashSet<>();


    public Client () {}


    public Client(String first, String last, String mail) {
        this.firstName = first;
        this.lastName = last;
        this.email = mail;
    }

    public Set<Account> getAccounts(){
        return accounts;
    }

    public void addAccount (Account account){
        account.setOwner(this);
        accounts.add(account);
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addClientLoan(ClientLoan clientLoan) {
        clientLoan.setOwner(this);
        clientLoans.add(clientLoan);
    }

    public Set<ClientLoan> getClientLoans() {
        return clientLoans;
    }

    public void setClientLoans(Set<ClientLoan> clientLoans) {
        this.clientLoans = clientLoans;
    }

    @JsonIgnore
    public List<Loan> getLoans() {
        return clientLoans.stream().map(sub -> sub.getLoan()).collect(toList());
    }


//    public String toString() {
//        return firstName + " " + lastName + " " + email;
//    }

}

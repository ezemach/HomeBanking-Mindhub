package com.mindhub.homebanking;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class HomeBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);

	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
		return (args) -> {

			Client client1 = new Client("Melba", "Lopez", "malba@hotmail.com");
			clientRepository.save(client1);
			Client client2 = new Client("Chloe", "O'Brian" , "pepe@hotmail.com");
			clientRepository.save(client2);

			Account account1 = new Account("VIN001",LocalDateTime.now(),5000.0);
			accountRepository.save(account1);
			Account account2 = new Account("VIN002",LocalDateTime.now(),7500.0);
			accountRepository.save(account2);
			Account account3 = new Account("VIN003",LocalDateTime.now(),4000.0);
			accountRepository.save(account3);
			Account account4 = new Account("VIN004",LocalDateTime.now(),3500.0);
			accountRepository.save(account4);

			client1.addAccount(account1);
			clientRepository.save(client1);
			accountRepository.save(account1);
			client1.addAccount(account2);
			clientRepository.save(client1);
			accountRepository.save(account2);

			client1.addAccount(account3);
			clientRepository.save(client2);
			accountRepository.save(account3);
			client1.addAccount(account4);
			clientRepository.save(client2);
			accountRepository.save(account4);

			Transaction transaction1 = new Transaction(TransactionType.DEBIT, 110.20, "Debito Tarjeta credito", LocalDateTime.now());
			transactionRepository.save(transaction1);
			account1.addTransaction(transaction1);
			accountRepository.save(account1);
			transactionRepository.save(transaction1);

			Transaction transaction2 = new Transaction(TransactionType.CREDIT, 800.50, "Credito Prestamo", LocalDateTime.now());
			transactionRepository.save(transaction2);
			account1.addTransaction(transaction2);
			accountRepository.save(account1);
			transactionRepository.save(transaction2);

			Transaction transaction3 = new Transaction(TransactionType.DEBIT, 550.10, "Debito personal", LocalDateTime.now());
			transactionRepository.save(transaction3);
			account1.addTransaction(transaction3);
			accountRepository.save(account1);
			transactionRepository.save(transaction3);

			Transaction transaction_1 = new Transaction(TransactionType.CREDIT, 90.00, "credito estatal", LocalDateTime.now());
			transactionRepository.save(transaction_1);
			account2.addTransaction(transaction_1);
			accountRepository.save(account2);
			transactionRepository.save(transaction_1);

			Transaction transaction_2 = new Transaction(TransactionType.DEBIT, 10.20, "Debito Servicio", LocalDateTime.now());
			transactionRepository.save(transaction_2);
			account2.addTransaction(transaction_2);
			accountRepository.save(account2);
			transactionRepository.save(transaction_2);




		};
	}
}



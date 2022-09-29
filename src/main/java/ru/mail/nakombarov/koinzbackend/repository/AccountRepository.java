package ru.mail.nakombarov.koinzbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mail.nakombarov.koinzbackend.data.entity.Account;

public interface AccountRepository extends CrudRepository<Account, String> {

}

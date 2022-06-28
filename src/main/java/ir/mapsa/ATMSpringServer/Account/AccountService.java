package ir.mapsa.ATMSpringServer.Account;

import ir.mapsa.ATMSpringServer.Exception.NotFoundException;
import ir.mapsa.ATMSpringServer.Person.IPersonService;
import ir.mapsa.ATMSpringServer.Person.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {
    private final IAccountRepository repository;
    private final IPersonService service;

    @Override
    public Account save(Account account) {
        Person person = service.getByID(account.getPerson().getId());
        account.setPerson(person);
        return repository.save(account);
    }

    @Override
    public Account update(Account account) {
        Account newAccount = getByID(account.getId());
        newAccount.setAccountNumber(account.getAccountNumber());
        newAccount.setPassword(account.getPassword());
        newAccount.setAccountType(account.getAccountType());
        newAccount.setBalance(account.getBalance());
        newAccount.setPerson(service.getByID(account.getPerson().getId()));
        return repository.save(newAccount);
    }

    @Override
    public List<Account> getAll() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Account getByID(long id) {
        Optional<Account> opt = repository.findById(id);
        if (opt.isEmpty()){
            throw new NotFoundException("Error!");
        }
        return opt.get();
    }

    @Override
    public void deleteByID(long id) {
        getByID(id);
        repository.deleteById(id);
    }
}

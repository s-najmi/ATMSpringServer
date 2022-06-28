package ir.mapsa.ATMSpringServer.Transaction;

import ir.mapsa.ATMSpringServer.Account.Account;
import ir.mapsa.ATMSpringServer.Account.IAccountService;
import ir.mapsa.ATMSpringServer.Exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionService implements ITransactionService {
    private final ITransactionRepository repository;
    private final IAccountService service;

    @Override
    public Transaction save(Transaction transaction) {
        Account account = service.getByID(transaction.getAccount().getId());
        transaction.setAccount(account);
        return repository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        Transaction newTransaction = getByID(transaction.getId());
        newTransaction.setAmount(transaction.getAmount());
        newTransaction.setTrDate(transaction.getTrDate());
        newTransaction.setTrType(transaction.getTrType());
        newTransaction.setAccount(service.getByID(transaction.getAccount().getId()));
        return repository.save(newTransaction);
    }

    @Override
    public List<Transaction> getAll() {
        return (List<Transaction>) repository.findAll();
    }

    @Override
    public Transaction getByID(long id) {
        Optional<Transaction> opt = repository.findById(id);
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

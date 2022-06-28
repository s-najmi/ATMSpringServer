package ir.mapsa.ATMSpringServer.Transaction;

import java.util.List;

public interface ITransactionService {
    Transaction save(Transaction transaction);
    Transaction update(Transaction transaction);
    List<Transaction> getAll();
    Transaction getByID(long id);
    void deleteByID(long id);
}

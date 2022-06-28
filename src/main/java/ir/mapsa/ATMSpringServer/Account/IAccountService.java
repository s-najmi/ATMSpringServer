package ir.mapsa.ATMSpringServer.Account;

import java.util.List;

public interface IAccountService {
    Account save(Account account);
    Account update(Account account);
    List<Account> getAll();
    Account getByID(long id);
    void deleteByID(long id);
}

package ir.mapsa.ATMSpringServer.Account;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
}

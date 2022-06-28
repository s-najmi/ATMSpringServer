package ir.mapsa.ATMSpringServer.Transaction;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
}

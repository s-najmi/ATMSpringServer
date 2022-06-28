package ir.mapsa.ATMSpringServer.Person;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends PagingAndSortingRepository<Person, Long> {
}

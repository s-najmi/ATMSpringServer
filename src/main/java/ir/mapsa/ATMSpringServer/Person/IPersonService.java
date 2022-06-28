package ir.mapsa.ATMSpringServer.Person;

import java.util.List;

public interface IPersonService {
    Person save(Person person);
    Person update(Person person);
    List<Person> getAll();
    Person getByID(long id);
    void deleteByID(long id);
}

package ir.mapsa.ATMSpringServer.Person;

import ir.mapsa.ATMSpringServer.Exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService implements IPersonService {
    private final IPersonRepository repository;

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Person update(Person person) {
        Person newPerson = getByID(person.getId());
        newPerson.setFullName(person.getFullName());
        newPerson.setBirthDate(person.getBirthDate());
        newPerson.setNationalCode(person.getNationalCode());
        return repository.save(newPerson);
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) repository.findAll();
    }

    @Override
    public Person getByID(long id) {
        Optional<Person> opt = repository.findById(id);
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

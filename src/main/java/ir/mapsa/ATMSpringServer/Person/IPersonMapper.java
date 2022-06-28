package ir.mapsa.ATMSpringServer.Person;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPersonMapper {
    Person toEntity(PersonDTO personDTO);
    List<Person> toEntitys(List<PersonDTO> personDTOs);

    PersonDTO toDTO(Person person);
    List<PersonDTO> toDTOs(List<Person> persons);
}
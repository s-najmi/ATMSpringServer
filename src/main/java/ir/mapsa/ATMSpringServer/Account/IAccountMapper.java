package ir.mapsa.ATMSpringServer.Account;

import ir.mapsa.ATMSpringServer.Person.IPersonMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IPersonMapper.class})
public interface IAccountMapper {
    Account toEntity(AccountDTO accountDTO);
    List<Account> toEntitys(List<AccountDTO> accountDTOs);

    AccountDTO toDTO(Account account);
    List<AccountDTO> toDTOs(List<Account> accounts);
}
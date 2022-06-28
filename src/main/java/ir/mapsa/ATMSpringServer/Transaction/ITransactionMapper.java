package ir.mapsa.ATMSpringServer.Transaction;

import ir.mapsa.ATMSpringServer.Account.IAccountMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {IAccountMapper.class})
public interface ITransactionMapper {
    Transaction toEntity(TransactionDTO transactionDTO);
    List<Transaction> toEntitys(List<TransactionDTO> transactionDTOs);

    TransactionDTO toDTO(Transaction transaction);
    List<TransactionDTO> toDTOs(List<Transaction> transactions);
}
package ir.mapsa.ATMSpringServer.Account;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.ATMSpringServer.Person.PersonDTO;
import ir.mapsa.ATMSpringServer.common.BaseDTO;
import lombok.Data;

@Data
public class AccountDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String accountNumber;

    @ApiModelProperty(required = true, hidden = false)
    private String password;

    @ApiModelProperty(required = true, hidden = false)
    private long balance;

    @ApiModelProperty(required = true, hidden = false)
    private AccountType accountType;

    @ApiModelProperty(required = true, hidden = false)
    private PersonDTO person;
}
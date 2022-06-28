package ir.mapsa.ATMSpringServer.Transaction;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.ATMSpringServer.Account.AccountDTO;
import ir.mapsa.ATMSpringServer.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private Date trDate;

    @ApiModelProperty(required = true, hidden = false)
    private long amount;

    @ApiModelProperty(required = true, hidden = false)
    private TransactionType trType;

    @ApiModelProperty(required = true, hidden = false)
    private AccountDTO account;
}
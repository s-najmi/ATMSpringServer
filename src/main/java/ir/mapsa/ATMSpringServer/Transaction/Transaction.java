package ir.mapsa.ATMSpringServer.Transaction;

import ir.mapsa.ATMSpringServer.Account.Account;
import ir.mapsa.ATMSpringServer.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_transaction")
public class Transaction extends BaseEntity {
    @NotNull
    @NotBlank
    @Column(name ="tr_date")
    @Temporal(TemporalType.DATE)
    private Date trDate;

    @NotNull
    @NotBlank
    @Column(name ="amount")
    private long amount;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.ORDINAL)
    @Column(name ="trType")
    private TransactionType trType;

    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name ="account_id")
    private Account account;
}

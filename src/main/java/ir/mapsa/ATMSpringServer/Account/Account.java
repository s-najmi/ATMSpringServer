package ir.mapsa.ATMSpringServer.Account;

import ir.mapsa.ATMSpringServer.Person.Person;
import ir.mapsa.ATMSpringServer.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tbl_account")
public class Account extends BaseEntity {
    @NotNull
    @NotBlank
    @Column(name ="account_number",unique = true)
    private String accountNumber;

    @NotNull
    @NotBlank
    @Column(name ="password")
    private String password;

    @NotNull
    @NotBlank
    @Column(name ="balance")
    private long balance;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.ORDINAL)
    @Column(name ="account_type")
    private AccountType accountType;

    @NotNull
    @NotBlank
    @ManyToOne
    @JoinColumn(name ="person_id")
    private Person person;
}

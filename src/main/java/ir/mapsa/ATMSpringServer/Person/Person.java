package ir.mapsa.ATMSpringServer.Person;

import ir.mapsa.ATMSpringServer.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_person")
public class Person extends BaseEntity {
    @NotNull
    @NotBlank
    @Column(name ="fullname")
    private String fullName;

    @NotNull
    @NotBlank
    @Column(name ="birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    @NotBlank
    @Column(name ="nationalcode")
    private String nationalCode;
}

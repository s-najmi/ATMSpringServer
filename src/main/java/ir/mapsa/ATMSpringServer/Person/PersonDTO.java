package ir.mapsa.ATMSpringServer.Person;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.ATMSpringServer.common.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String fullName;

    @ApiModelProperty(required = true, hidden = false)
    private Date birthDate;

    @ApiModelProperty(required = true, hidden = false)
    private String nationalCode;
}
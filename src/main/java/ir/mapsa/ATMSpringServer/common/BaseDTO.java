package ir.mapsa.ATMSpringServer.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {
    @ApiModelProperty(required = false, hidden = true)
    private long id;

    @ApiModelProperty(required = false, hidden = true)
    private Integer version;

    @ApiModelProperty(required = false, hidden = true)
    private Date createdDate;

    @ApiModelProperty(required = false, hidden = true)
    private String createdBy;

    @ApiModelProperty(required = false, hidden = true)
    private Date lastModified;

    @ApiModelProperty(required = false, hidden = true)
    private String lastModifiedBy;
}

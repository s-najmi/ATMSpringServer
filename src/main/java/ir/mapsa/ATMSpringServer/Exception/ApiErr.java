package ir.mapsa.ATMSpringServer.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiErr {
    private String msg;
    private HttpStatus status;
}

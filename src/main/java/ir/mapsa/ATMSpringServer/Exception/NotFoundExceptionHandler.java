package ir.mapsa.ATMSpringServer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class NotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> notFoundExceptionHandler(NotFoundException notFoundException){
        ApiErr apiErr =new ApiErr(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return buildResponseEntity(apiErr);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiErr apiErr) {
        return new ResponseEntity<>(apiErr,apiErr.getStatus());
    }
}

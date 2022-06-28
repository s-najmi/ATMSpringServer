package ir.mapsa.ATMSpringServer.Transaction;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
@AllArgsConstructor
public class TransactionController {
    private final ITransactionService service;
    private final ITransactionMapper mapper;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done Successfully..."),
            @ApiResponse(responseCode = "201", description = "Creadted Successfully..."),
            @ApiResponse(responseCode = "404", description = "Missing Record...")
    })

    @PostMapping("/")
    public ResponseEntity<TransactionDTO> addNewTransaction(@RequestBody TransactionDTO transactionDTO){
        Transaction newTransaction = mapper.toEntity(transactionDTO);
        return new ResponseEntity<>(mapper.toDTO(service.save(newTransaction)), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<TransactionDTO> updateTransaction(@RequestBody TransactionDTO transactionDTO){
        Transaction newTransaction = mapper.toEntity(transactionDTO);
        return new ResponseEntity<>(mapper.toDTO(service.update(newTransaction)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDTO>> getAllTransaction(){
        return new ResponseEntity<>(mapper.toDTOs(service.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionByID(@PathVariable long id){
        return new ResponseEntity<>(mapper.toDTO(service.getByID(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionByID(@PathVariable long id){
        service.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

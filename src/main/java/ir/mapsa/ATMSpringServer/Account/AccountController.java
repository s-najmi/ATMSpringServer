package ir.mapsa.ATMSpringServer.Account;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
@AllArgsConstructor
public class AccountController {
    private final IAccountService service;
    private final IAccountMapper mapper;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done Successfully..."),
            @ApiResponse(responseCode = "201", description = "Creadted Successfully..."),
            @ApiResponse(responseCode = "404", description = "Missing Record...")
    })

    @PostMapping("/")
    public ResponseEntity<AccountDTO> addNewAccount(@RequestBody AccountDTO accountDTO){
        Account newAccount = mapper.toEntity(accountDTO);
        return new ResponseEntity<>(mapper.toDTO(service.save(newAccount)), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO){
        Account newAccount = mapper.toEntity(accountDTO);
        return new ResponseEntity<>(mapper.toDTO(service.update(newAccount)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountDTO>> getAllAccount(){
        return new ResponseEntity<>(mapper.toDTOs(service.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountByID(@PathVariable long id){
        return new ResponseEntity<>(mapper.toDTO(service.getByID(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountByID(@PathVariable long id){
        service.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

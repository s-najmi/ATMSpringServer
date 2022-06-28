package ir.mapsa.ATMSpringServer.Person;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/person")
@AllArgsConstructor
public class PersonController {
    private final IPersonService service;
    private final IPersonMapper mapper;
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done Successfully..."),
            @ApiResponse(responseCode = "201", description = "Creadted Successfully..."),
            @ApiResponse(responseCode = "404", description = "Missing Record...")
    })

    @PostMapping("/")
    public ResponseEntity<PersonDTO> addNewPerson(@RequestBody PersonDTO personDTO){
        Person newPerson = mapper.toEntity(personDTO);
        return new ResponseEntity<>(mapper.toDTO(service.save(newPerson)), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO){
        Person newPerson = mapper.toEntity(personDTO);
        return new ResponseEntity<>(mapper.toDTO(service.update(newPerson)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonDTO>> getAllPerson(){
        return new ResponseEntity<>(mapper.toDTOs(service.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonByID(@PathVariable long id){
        return new ResponseEntity<>(mapper.toDTO(service.getByID(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonByID(@PathVariable long id){
        service.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

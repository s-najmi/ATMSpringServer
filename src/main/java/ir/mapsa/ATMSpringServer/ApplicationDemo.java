package ir.mapsa.ATMSpringServer;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(info = @Info(
        title = "Add new applicant",
        version = "1.0",
        description = "using to add new person",
        contact = @Contact(url = "localhost:9090", email = "t@yahoo.com")
))

@SpringBootApplication
@EnableJpaAuditing
public class ApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDemo.class);
    }
}

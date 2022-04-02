package pl.sdacademy.springpractice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties("client")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ClientCredentials {

    @NotEmpty(message = "username is mandatory")
    private String username;

    @Length(min = 5, message = "password too short")
    private String password;
}

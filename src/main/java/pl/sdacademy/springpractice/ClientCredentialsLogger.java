package pl.sdacademy.springpractice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientCredentialsLogger implements CommandLineRunner {

    private final ClientCredentials clientCredentials;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(clientCredentials.getUsername());
        System.out.println(clientCredentials.getPassword());
    }
}

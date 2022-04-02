package pl.sdacademy.springpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// rejestracja wielu beanów do kontekstu

@Configuration
public class SomeClassConfiguration {

    @Bean
    public SomeClassA someClassA() {
        return new SomeClassA();
    }

    @Bean
    public SomeClassB someClassB() {
        return new SomeClassB();
    }

    @Bean
    public SomeClassC someClassC() {
        return new SomeClassC();
    }
}

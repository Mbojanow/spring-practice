package pl.sdacademy.springpractice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ClassC implements InterfaceA {
    @Override
    public void hi() {
        System.out.println("hello");
    }
}

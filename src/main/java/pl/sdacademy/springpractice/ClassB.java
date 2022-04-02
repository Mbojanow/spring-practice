package pl.sdacademy.springpractice;

import org.springframework.stereotype.Component;

@Component("classB2")
public class ClassB implements InterfaceA {
    @Override
    public void hi() {
        System.out.println("hi");
    }
}

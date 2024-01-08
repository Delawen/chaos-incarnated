package com.example;

import com.example.model.Cat;
import io.micronaut.runtime.Micronaut;
import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport(Cat.class)
public class MicronautApplication {
    public static void main(String[] args) {
        Micronaut.run(MicronautApplication.class, args);
    }
}
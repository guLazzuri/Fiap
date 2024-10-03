package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        var clienteRepository = new ClienteRepository();
        clienteRepository.Inserir(new Cliente(1, "Leo", 30));
        //clienteRepository.Inserir(new Endereco(1, "Rua 1", 10, "Casa 1"));
    }
}
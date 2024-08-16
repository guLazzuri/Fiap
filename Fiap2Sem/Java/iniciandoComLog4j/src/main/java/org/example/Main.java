package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        try{
            logger.info("SIstema iniciando......");
            var scanner = new Scanner(System.in);
            System.out.println("Digite um numero: ");
            int numero = scanner.nextInt();

        }
        catch (Exception e){

            logger.fatal("Erro fatal" + e.getMessage() + "  - " + Arrays.toString(e.getStackTrace()));
        }
    }
}
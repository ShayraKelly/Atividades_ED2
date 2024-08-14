package Algoritmo_DSW;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random gerador = new Random();

        for (int i = 0; i < 100; i++) {
            int numeroAleatorio = gerador.nextInt(101);
            arvore.inserir(numeroAleatorio);
            System.out.println(numeroAleatorio);
        }
        
    }
}
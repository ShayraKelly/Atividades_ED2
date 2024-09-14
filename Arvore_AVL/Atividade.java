package Arvore_AVL;

import java.util.Random;
import java.util.Scanner;

public class Atividade {
    public static void main(String[] args) {
        Arvore_AVL avl = new Arvore_AVL();
        Random sorteio = new Random();
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;

        while(opcao != 0){
            System.out.println("\n\n0 - Para finalizar o Sistema");
            System.out.println("1 - Para adicionar 100 Valores");
            System.out.println("2 - Para remover 20 valores");
            System.out.printf("Escolha uma Opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {            
                for(int i=0; i < 100; i++){
                    int numero = sorteio.nextInt((500 - -500) + 1) + -500;
                    avl.setRaiz(numero);
                }
                No raiz = avl.getRaiz();
                boolean arvoreBalanceada = avl.getBalanceamento(raiz);

                if(arvoreBalanceada == true){
                    System.out.println("Arvore Balanceada!");
                }
                else {
                    System.out.println("A arvore está Desbalanceada!");
                }
            }
            
            else if(opcao == 2){
                    for(int i=0; i < 20; i++){
                        int numero = sorteio.nextInt((100 - 0) + 1) + 0;
                        avl.setRaiz(numero);
                        avl.remocao(i);
                    }
                No raiz = avl.getRaiz();
                boolean arvoreBalanceadaRemocao = avl.getBalanceamento(raiz);

                if(arvoreBalanceadaRemocao == true){
                    System.out.println("\n\nBalanceada!");
                }
                else {
                    System.out.println("\n\nDesbalanceada!");
                } 
            }

            else if(opcao == 0){
                System.out.println("Sistema finalizado!");
            }

            else{
                System.out.println("Opção não disponível!");
            }
        }

    }
}
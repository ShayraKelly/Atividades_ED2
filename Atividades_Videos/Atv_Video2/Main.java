package Atividades_Videos.Atv_Video2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)   
 throws FileNotFoundException {
        File arquivo = new File("dados500_mil.txt");
        Scanner scanner = new Scanner(arquivo);

        // Armazena os dados do arquivo em um array
        int[] dados = new int[500000]; // Ajuste o tamanho conforme necessário
        int i = 0;
        while (scanner.hasNext()) {
            dados[i++] = scanner.nextInt();
        }
        scanner.close();

        // Cria a árvore binária a partir do array
        ArvoreBinaria arvore = new ArvoreBinaria();
        for (int numero : dados) {
            arvore.setRaiz(numero);
        }

        System.out.println("In ordem:");
        arvore.Inordem(arvore.getRaiz());
    }
}
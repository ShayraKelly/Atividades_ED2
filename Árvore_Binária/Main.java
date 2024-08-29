import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random gerador = new Random();
        int numeroAleatorio = 0;

        System.out.println("===========");

        for (int i = 0; i < 20; i++) {
            numeroAleatorio = gerador.nextInt(101);
            System.out.println("    " + numeroAleatorio);
        }

        System.out.println("===========\n");

    System.out.println("Pré-ordem:");
    arvore.preOrdem(arvore.getRaiz());

    System.out.println("In ordem:");
    arvore.inOrdem(arvore.getRaiz());

    System.out.println("Pós-ordem:");
    arvore.posOrdem(arvore.getRaiz());

    System.out.println("\nApós as remoções:");
    arvore.remover(arvore.getRaiz(), numeroAleatorio);
    }
}

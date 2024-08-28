import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        int numeroAleatorio = 0;

        System.out.println("===========");

        for (int i = 0; i < 20; i++) {
            numeroAleatorio = gerador.nextInt(101);
            System.out.println("    " + numeroAleatorio);
        }

        System.out.println("===========\n");

    System.out.println("Pré-ordem:");
    ArvoreBinaria.preOrdem(noarvore.getNoArvore());
    System.out.println("In ordem:");
    ArvoreBinaria.inOrdem(ArvoreBinaria.getNoArvore());
    System.out.println("Pós-ordem:");
    ArvoreBinaria.posOrdem(ArvoreBinaria.getNoArvore());

    ArvoreBinaria.remover(NoArvore.getNoRaiz(), valor1);
    ArvoreBinaria.remover(NoArvore.getNoRaiz(), valor2);

    System.out.println("\nApós as remoções:");

    }
}

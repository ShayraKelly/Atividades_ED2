import java.util.Random;

public class Arvore {
    public static void main(String[] args) {
        Random gerador = new Random();
        int numeroAleatorio = 0;

        for (int i = 0; i < 20; i++) {
            numeroAleatorio = gerador.nextInt(101);
            System.out.println(numeroAleatorio);
        }

        System.out.println("======================================\n" + numeroAleatorio);

    }
}
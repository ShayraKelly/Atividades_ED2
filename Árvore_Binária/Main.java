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

    }
}

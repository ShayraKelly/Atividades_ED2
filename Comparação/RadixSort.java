import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) throws IOException {
        int[] array = {90, 87, -6, 4, 1, 0, -70, -15}; //arquivo("dados100_mil.txt");
        if (array != null) {
            long startTime = System.currentTimeMillis();
            int digito = maximo(array);
            radixSort(array, 0, array.length - 1, digito);
            System.out.println("Vetor: " + Arrays.toString(array));
            long endTime = System.currentTimeMillis();
            long tempoFinal = endTime - startTime;
            tempo(tempoFinal);
        }
    }

    public static void radixSort(int[] array, int indexIni, int indexFim, int digito) {
        if (indexIni < indexFim && digito >= 0) {
            int[] count = new int[19];
            int[] temp = new int[indexFim - indexIni + 1];

            int atualIndexIni;
            int i;
            for(atualIndexIni = indexIni; atualIndexIni <= indexFim; ++atualIndexIni) {
                i = buscaValorDigito(array[atualIndexIni], digito);
                ++count[i + 9];
            }

            for(atualIndexIni = 1; atualIndexIni < 19; ++atualIndexIni) {
                count[atualIndexIni] += count[atualIndexIni - 1];
            }

            for(atualIndexIni = indexFim; atualIndexIni >= indexIni; --atualIndexIni) {
                i = buscaValorDigito(array[atualIndexIni], digito);
                temp[count[i + 9] - 1] = array[atualIndexIni];
                --count[i + 9];
            }

            System.arraycopy(temp, 0, array, indexIni, indexFim - indexIni + 1);
            atualIndexIni = indexIni;

            for(i = 0; i < 19; ++i) {
                int atualIndexFim = indexIni + count[i] - 1;
                radixSort(array, atualIndexIni, atualIndexFim, digito - 1);
                atualIndexIni = indexIni + count[i];
            }
        }
    }

    public static int buscaValorDigito(int valor, int digito) {
        for (int i = 0; i < digito; i++) {
            valor /= 10;
        }
        return valor % 10;
    }

    public static int[] arquivo(String url) throws IOException {
        Path array = Path.of(url);
        if (Files.notExists(array, LinkOption.NOFOLLOW_LINKS)) {
            return null;
        } else {
            String valoresString = Files.readString(array);
            String formataValor = valoresString.replace("[", "").replace("]", "").replace(" ", "");
            String[] arrayString = formataValor.split(",");
            int[] arrayInt = new int[arrayString.length];

            for(int i = 0; i < arrayString.length; ++i) {
                arrayInt[i] = Integer.valueOf(arrayString[i]);
            }

            return arrayInt;
        }
    }

    public static int maximo(int[] array) {
        int maior = 0;
        for(int valor : array) {
            int numero = contar(valor);
            if (numero > maior) {
                maior = numero;
            }
        }
        return maior;
    }

    public static int contar(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            ++count;
        }
        return count;
    }

    public static void tempo(long tempoFinal) {
        long horas;
        horas = tempoFinal / 3600000;
        long minutos;
        minutos = (tempoFinal % 3600000) / 60000;
        long segundos;
        segundos = ((tempoFinal % 3600000) % 60000) / 1000;
        long milissegundos;
        milissegundos = tempoFinal % 1000;
        System.out.println("Tempo de execução: " + horas + "h " + minutos + "min " + segundos + "s " + milissegundos + "ms");
    }
}


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        int[] array = arquivo("dados100_mil.txt");
        if (array != null) {
            long startTime = System.currentTimeMillis();
            int[] arrayAux = new int[array.length];
            mergeSort(array, arrayAux, 0, array.length - 1);
            System.out.println("Vetor: " + Arrays.toString(array));
            long endTime = System.currentTimeMillis();
            long tempoFinal = endTime - startTime;
            tempo(tempoFinal);
        }
    }

    public static void mergeSort(int[] array, int[] arrayAux, int Inicio, int Fim) {
        if (Inicio < Fim) {
            int Meio = (Inicio + Fim) / 2;
            mergeSort(array, arrayAux, Inicio, Meio);
            mergeSort(array, arrayAux, Meio + 1, Fim);
            merge(array, arrayAux, Inicio, Meio, Fim);
        }
    }

    public static void merge(int[] arr, int[] aux, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        StringBuilder positive = new StringBuilder();
        StringBuilder negative = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negative.append(arr[i]).append(" ");
            } else {
                positive.append(arr[i]).append(" ");
            }
        }
        
    }

    public static int[] arquivo(String url) throws IOException {
        Path array = Path.of(url);
        if (Files.notExists(array, new LinkOption[0])) {
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
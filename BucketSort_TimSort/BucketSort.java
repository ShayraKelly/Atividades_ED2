import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int bucketSize = 10;
        long startTime = System.currentTimeMillis();
        System.out.println("Shayra Kelly Eleotério Silva");
        System.out.println("Bucket Sort");
        System.out.println("Array antes:");
        System.out.println(Arrays.toString(arr));
        
        int[] comparacoes_movimentos = {0 ,0};
        
        bucketSort(arr, bucketSize, comparacoes_movimentos);
        
        System.out.println("Array depois:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Quantidade de comparações: " + comparacoes_movimentos[0]);
        System.out.println("Quantidade de movimentos: " + comparacoes_movimentos[1]);
        long endTime = System.currentTimeMillis();
        long tempoFinal = endTime - startTime;
        tempo(tempoFinal);
    }

    public static void bucketSort(int[] arr, int bucketSize, int[] comparacoes_movimentos) {
        if (arr.length == 0) {
            return;
        }

        // Encontre o valor máximo e mínimo do array
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        // Calcule o número de baldes
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Adicione os elementos aos baldes
        for (int value : arr) {
            int bucketIndex = (value - minValue) / bucketSize;
            buckets.get(bucketIndex).add(value);
        }

        // Classifique individualmente os baldes e recombine
        int currentIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                comparacoes_movimentos[0]++; // Incrementa comparações para cada elemento do array
                if (arr[currentIndex] != value) {
                    comparacoes_movimentos[1]++; // Incrementa movimentos apenas se o elemento atual for diferente do valor do balde
                }
                arr[currentIndex++] = value;
            }
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

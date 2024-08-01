package Atv1;

import java.util.Arrays;

public class DijkstraAlgorithm {

    // Método para encontrar o vértice com a distância mínima que ainda não foi visitado
    private static int getMinDistanceVertex(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }

    // Implementação do algoritmo de Dijkstra
    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V]; // dist[i] armazenará a menor distância de src até i
        boolean[] visited = new boolean[V]; // visited[i] será verdadeiro se o vértice i for incluído no caminho mais curto

        // Inicializa todas as distâncias como INFINITO e visited[] como falso
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        // A distância da fonte para ela mesma é sempre 0
        dist[src] = 0;

        // Encontra o caminho mais curto para todos os vértices
        for (int count = 0; count < V - 1; count++) {
            // Pega o vértice de distância mínima dos vértices ainda não processados
            int u = getMinDistanceVertex(dist, visited);

            // Marca o vértice como processado
            visited[u] = true;

            // Atualiza o valor de dist dos vértices adjacentes ao vértice escolhido
            for (int v = 0; v < V; v++) {
                // Atualiza dist[v] se não estiver em visited, existe uma aresta de u para v,
                // e o peso total do caminho de src para v através de u é menor do que o valor atual de dist[v]
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Imprime a matriz de distância construída
        System.out.println("Distância do vértice origem:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vértice " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // Define um grafo de 14 vértices como uma matriz de adjacência
        int[][] graph = new int[][] {
            {0, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 4, 2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {4, 4, 0, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 7, 5, 4, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 1, 0, 2, 5, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 3, 2, 0, 2, 3, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 5, 2, 0, 2, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 3, 2, 0, 3, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 2, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 1, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 2, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0}
        };
        
        // Chama o algoritmo de Dijkstra a partir do vértice 0
        dijkstra(graph, 0);
    }
}
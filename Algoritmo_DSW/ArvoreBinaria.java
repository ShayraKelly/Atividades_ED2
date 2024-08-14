package Algoritmo_DSW;

public class ArvoreBinaria{
    private No raiz;

    public void inserir(int valor) {
        raiz = inserirDSW(raiz, valor);
    }

    private No inserirDSW(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerdo = inserirDSW(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = inserirDSW(no.direito, valor);
        } else {
            return no;
        }

        return no;
    }
}
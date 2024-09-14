package Arvore_AVL;

public class No {
    private int altura;
    private int no;
    private No filho_esquerdo;
    private No filho_direito;

    //Construtor
    public No(int valorNo) {
        this.no = valorNo;
        this.filho_esquerdo = null;
        this.filho_direito = null;

    }

    //encapsulamento

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNo() {
        return no;
    }

    public void setValorNo(int valor) {
        this.no = valor;
    }

    public No getFilhoEsquerdo() {
        return filho_esquerdo;
    }

    public void setFilhoEsquerdo(No noEsquerdo) {
        this.filho_esquerdo = noEsquerdo;
    }

    public No getFilhoDireito() {
        return filho_direito;
    }

    public void setFilhoDireito(No noDireito) {
        this.filho_direito = noDireito;
    }
}
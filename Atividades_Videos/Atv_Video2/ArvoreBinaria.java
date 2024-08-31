package Atividades_Videos.Atv_Video2;

public class ArvoreBinaria {
    private No noRaiz;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public No getNoRaiz() {
        return this.noRaiz;
    }

    public void setNoRaiz(int valor) {
        this.noRaiz = inserir(this.noRaiz, valor);
    }

    private No inserir(No no, int valor) {
        if (no != null) {
            if (valor < no.getValor()) {
                no.setNoEsq(inserir(no.getNoEsq(), valor));
            } else if (valor > no.getValor()) {
                no.setNoDir(inserir(no.getNoDir(), valor));
            }
            return no;
        } else {
            return new No(valor);
        }
    }
}
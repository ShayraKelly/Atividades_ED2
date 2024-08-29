public class ArvoreBinaria {
    private NoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public NoArvore getRaiz() {
        return this.raiz;
    }

    public void setRaiz(int valor) {
        this.raiz = addNo(this.raiz, valor);
    }

    private NoArvore addNo(NoArvore no, int valor){
        if(no != null){
            if(valor < no.getValor()){
                no.setNoEsq(addNo(no.getNoEsq(), valor));
            }else if(valor > no.getValor()){
                no.setNoDir(addNo(no.getNoDir(), valor));
            }
            return no;
        }else{
            return new NoArvore(valor);
        }
    }

    //Pré-ordem
    public void preOrdem(NoArvore no) {
        if (no != null) {
            System.out.print(no.getValor() + " ");
            preOrdem(no.getNoEsq());
            preOrdem(no.getNoDir());
        }
    }

    //In-ordem
    public void inOrdem(NoArvore no) {
        if (no != null) {
            inOrdem(no.getNoEsq());
            System.out.print(no.getValor() + " ");
            inOrdem(no.getNoDir());
        }
    }

    //Pós-ordem
    public void posOrdem(NoArvore no) {
        if (no != null) {
            posOrdem(no.getNoEsq());
            posOrdem(no.getNoDir());
            System.out.print(no.getValor() + " ");
        }
    }

    public NoArvore remover(NoArvore no, int valor) {
        if (no == null) {
            return no;
        }

        if (valor < no.getValor()) {
            no.setNoEsq(remover(no.getNoEsq(), valor));
        } else if (valor > no.getValor()) {
            no.setNoDir(remover(no.getNoDir(), valor));
        } else {
            if (no.getNoEsq() == null) {
                return no.getNoDir();
            } else if (no.getNoDir() == null) {
                return no.getNoEsq();
            }

            NoArvore temp = minimo(no.getNoDir());
            no.setValor(temp.getValor());
            no.setNoDir(remover(no.getNoDir(), temp.getValor()));
        }
        NoArvore temp = maximo(no.getNoEsq()); // Encontra o maior valor da subárvore esquerda
        no.setValor(temp.getValor());
        no.setNoEsq(remover(no.getNoEsq(), temp.getValor()));
        return no;
    }

    private NoArvore maximo(NoArvore no) {
        NoArvore atual = no;
        while (atual.getNoDir() != null) {
            atual = atual.getNoDir();
        }
        return atual;
    }

    private NoArvore minimo(NoArvore no) {
        NoArvore atual = no;
        while (atual.getNoEsq() != null) {
            atual = atual.getNoEsq();
        }
        return atual;
    }
}

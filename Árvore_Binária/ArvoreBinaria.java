public class ArvoreBinaria {
    private NoArvore noRaiz;

    public ArvoreBinaria() {
        this.noRaiz = null;
    }

    public NoArvore getNoRaiz() {
        return this.noRaiz;
    }

    public void setNoRaiz(int valor) {
        this.noRaiz = Add_No(this.noRaiz, valor);
    }

    private NoArvore Add_No(NoArvore no, int valor){
        if(no != null){
            if(valor < no.getValor()){
                no.setNoEsq(Add_No(no.getNoEsq(), valor));
            }else if(valor > no.getValor()){
                no.setNoDir(Add_No(no.getNoDir(), valor));
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
        return no;
    }

    private NoArvore minimo(NoArvore no) {
        NoArvore atual = no;
        while (atual.getNoEsq() != null) {
            atual = atual.getNoEsq();
        }
        return atual;
    }
}

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

    

}
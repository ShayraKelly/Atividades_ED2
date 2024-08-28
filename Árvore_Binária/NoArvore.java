public class NoArvore { 
    private int valor; 
    private NoArvore noDir; 
    private NoArvore noEsq; 

    
    public NoArvore(int valor) {
        this.valor = valor;
        this.noDir = null;
        this.noEsq = null;
    }


    public int getValor() {
        return valor;
    }


    public void setValor(int valor) {
        this.valor = valor;
    }


    public NoArvore getNoDir() {
        return noDir;
    }


    public void setNoDir(NoArvore noDir) {
        this.noDir = noDir;
    }


    public NoArvore getNoEsq() {
        return noEsq;
    }


    public void setNoEsq(NoArvore noEsq) {
        this.noEsq = noEsq;
    }

}

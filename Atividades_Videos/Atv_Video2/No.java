package Atividades_Videos.Atv_Video2;

public class No {
        private int valor;
        private No NoEsq, NoDir;

        public No(int valor) {
            this.valor = valor;
            NoEsq = NoDir = null;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public No getNoEsq() {
            return NoEsq;
        }

        public void setNoEsq(No noEsq) {
            NoEsq = noEsq;
        }

        public No getNoDir() {
            return NoDir;
        }

        public void setNoDir(No noDir) {
            NoDir = noDir;
        }
}
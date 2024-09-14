package Arvore_AVL;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class Arvore_AVL {
    private No raiz;

    public Arvore_AVL() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(int valNo) {
        this.raiz = insereNo(this.raiz, valNo);
    }

    public No insereNo(No no, int valor) {
        if (no == null) {
            no = new No(valor);
            status(no);
            return no;
        } else if (valor < no.getNo()) {
            no.setFilhoEsquerdo(insereNo(no.getFilhoEsquerdo(), valor));
        } else if (valor > no.getNo()) {
            no.setFilhoDireito(insereNo(no.getFilhoDireito(), valor));
        }

        no = AtualizaAlturaInsercao(no);

        status(no);
        return no;
    }
    

    public void remocao(int valorNo) {
        this.raiz = removeNo(this.raiz, valorNo);
    }

    public No removeNo(No no, int val) {
        if (no == null) {
            return null;
        }

        if (val < no.getNo()) {
            no.setFilhoEsquerdo(removeNo(no.getFilhoEsquerdo(), val));
        } else if (val > no.getNo()) {
            no.setFilhoDireito(removeNo(no.getFilhoDireito(), val));
        } else {
            if (no.getFilhoEsquerdo() == null) {
                return no.getFilhoDireito();
            } else if (no.getFilhoDireito() == null) {
                return no.getFilhoEsquerdo();
            }
            No temp = minimoValorNo(no.getFilhoDireito());
            no.setValorNo(temp.getNo());
            no.setFilhoDireito(removeNo(no.getFilhoDireito(), temp.getNo()));
        }

        no = AtualizaAlturaRemocao(no);

        status(no);
        return no;
    }

    private void status(No no) {
        if (no != null) {
            System.out.println("O fator de Balanceamento do número " + no.getNo() + " é " + balandeamentoArvore(no));
        }
    }

    public No rotacaoLL(No no) {
        No filhoEsquerdo = no.getFilhoEsquerdo();
        no.setFilhoEsquerdo(filhoEsquerdo.getFilhoDireito());
        filhoEsquerdo.setFilhoDireito(no);

        no.setAltura(1 + max(altura(no.getFilhoEsquerdo()), altura(no.getFilhoDireito())));
        filhoEsquerdo.setAltura(1 + max(altura(filhoEsquerdo.getFilhoEsquerdo()), altura(filhoEsquerdo.getFilhoDireito())));

        return filhoEsquerdo;
    }

    public No rotacaoRR(No no) {
        No filhoDireito = no.getFilhoDireito();

        if (filhoDireito == null) {
            return no;
        }

        no.setFilhoDireito(filhoDireito.getFilhoEsquerdo());
        filhoDireito.setFilhoEsquerdo(no);

        no.setAltura(1 + max(altura(no.getFilhoEsquerdo()), altura(no.getFilhoDireito())));
        filhoDireito.setAltura(1 + max(altura(filhoDireito.getFilhoEsquerdo()), altura(filhoDireito.getFilhoDireito())));

        return filhoDireito;
    }

    public No rotacaoLR(No no) {
        no.setFilhoEsquerdo(rotacaoRR(no.getFilhoEsquerdo()));
        return rotacaoRR(no);
    }

    public No rotacaoRL(No no) {
        no.setFilhoDireito(rotacaoLL(no.getFilhoDireito()));
        return rotacaoLL(no);
    }

    private No AtualizaAlturaInsercao(No no) {
        no.setAltura(1 + max(altura(no.getFilhoEsquerdo()), altura(no.getFilhoDireito())));

        int balanceamento = balandeamentoArvore(no);

        if (balanceamento > 1) {
            if (balandeamentoArvore(no.getFilhoEsquerdo()) >= 0) {
                no = rotacaoLL(no);
            } else {
                no.setFilhoEsquerdo(rotacaoRR(no.getFilhoEsquerdo()));
                no = rotacaoLL(no);
            }
        } else if (balanceamento < -1) {
            if (balandeamentoArvore(no.getFilhoDireito()) <= 0) {
                no = rotacaoRR(no);
            } else {
                no.setFilhoDireito(rotacaoLL(no.getFilhoDireito()));
                no = rotacaoRR(no);
            }
        }
        return no;
    }

    private No AtualizaAlturaRemocao(No no) {
        no.setAltura(1 + max(altura(no.getFilhoEsquerdo()), altura(no.getFilhoDireito())));

        int balanceamento = balandeamentoArvore(no);

        if (balanceamento > 1) {
            if (balandeamentoArvore(no.getFilhoEsquerdo()) >= 0) {
                no = rotacaoLL(no);
            } else {
                no.setFilhoEsquerdo(rotacaoRR(no.getFilhoEsquerdo()));
                no = rotacaoLL(no);
            }
        } else if (balanceamento < -1) {
            if (balandeamentoArvore(no.getFilhoDireito()) <= 0) {
                no = rotacaoRR(no);
            } else {
                no.setFilhoDireito(rotacaoLL(no.getFilhoDireito()));
                no = rotacaoRR(no);
            }
        }
        return no;
    }

    public No minimoValorNo(No no) {
        No atual = no;
        while (atual.getFilhoEsquerdo() != null) {
            atual = atual.getFilhoEsquerdo();
        }
        return atual;
    }

    private int altura(No no) {
        if(no != null){
            return no.getAltura();
        }
        else{
            return 0;
        }
    }

    private int balandeamentoArvore(No no) {
        if (no != null) {
            return altura(no.getFilhoEsquerdo()) - altura(no.getFilhoDireito());
        } else {
            return 0;
        }
    }

    public boolean getBalanceamento(No no) {
        if (no == null) {
            return true;
        }

        int balanceamento = balandeamentoArvore(no);
        return (balanceamento >= -1 && balanceamento <= 1) && getBalanceamento(no.getFilhoEsquerdo()) && getBalanceamento(no.getFilhoDireito());
    }


    public void imprimirArvore(No raiz) {
        if (raiz == null) {
            return;
        }
        Queue<No> nos = new LinkedList<>();
        nos.add(raiz);

        while (!nos.isEmpty()) {
            No no = nos.poll();
            System.out.printf(no.getNo() + ", ");

            if (no.getFilhoEsquerdo() != null) {
                nos.add(no.getFilhoEsquerdo());
            }

            if (no.getFilhoDireito() != null) {
                nos.add(no.getFilhoDireito());
            }
        }
    }
}
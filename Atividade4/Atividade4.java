package org.service.Atividade4;

class Elemento {
    int dado;
    Elemento previo, seguinte;

    Elemento(int dado) {
        this.dado = dado;
        this.previo = null;
        this.seguinte = null;
    }
}

public class Atividade4 {
    private Elemento topoPilha;

    public Atividade4() {
        this.topoPilha = null;
    }

    public void empilhar(int dado) {
        Elemento novoElemento = new Elemento(dado);
        if (this.topoPilha != null) {
            this.topoPilha.previo = novoElemento;
            novoElemento.seguinte = this.topoPilha;
        }
        this.topoPilha = novoElemento;
    }

    public int desempilhar() {
        if (estaVazia()) {
            System.err.println("Erro: Tentativa de desempilhar de uma pilha vazia.");
            return -1;
        }
        int dadoRemovido = this.topoPilha.dado;
        this.topoPilha = this.topoPilha.seguinte;
        if (this.topoPilha != null) {
            this.topoPilha.previo = null;
        }
        return dadoRemovido;
    }

    public int verTopo() {
        if (estaVazia()) {
            System.err.println("Erro: Tentativa de ver o topo de uma pilha vazia.");
            return -1;
        }
        return this.topoPilha.dado;
    }

    public boolean estaVazia() {
        return this.topoPilha == null;
    }

    public static void main(String[] args) {
        Atividade4 minhaPilha = new Atividade4();

        minhaPilha.empilhar(100);
        minhaPilha.empilhar(200);
        minhaPilha.empilhar(300);

        System.out.println("Elemento no topo: " + minhaPilha.verTopo());
        System.out.println("Elemento desempilhado: " + minhaPilha.desempilhar());
        System.out.println("Novo elemento no topo: " + minhaPilha.verTopo());
        minhaPilha.desempilhar();
        minhaPilha.desempilhar();
        System.out.println("Pilha está vazia? " + minhaPilha.estaVazia());
        minhaPilha.desempilhar();
    }
}
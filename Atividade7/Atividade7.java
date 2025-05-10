package org.service.Atividade7;

public class Atividade7 {

    static final int TAMANHO_MAX = 10;

    static class No {
        int valor;
        int proximo;

        public No() {
            this.valor = 0;
            this.proximo = -1;
        }
    }

    static class Lista {
        No[] nos = new No[TAMANHO_MAX];
        int inicio = -1;
        int disponivel = 0;

        public Lista() {

            for (int i = 0; i < TAMANHO_MAX; i++) {
                nos[i] = new No();
                nos[i].proximo = i + 1;
            }
            nos[TAMANHO_MAX - 1].proximo = -1;
        }

        private int alocaNo() {
            if (disponivel == -1) {
                System.out.println("ERRO: Lista cheia!");
                return -1;
            }
            int indice = disponivel;
            disponivel = nos[indice].proximo;
            return indice;
        }

        private void liberaNo(int indice) {
            nos[indice].proximo = disponivel;
            disponivel = indice;
        }

        public void inserir(int valor) {
            int novoIndice = alocaNo();
            if (novoIndice == -1) return;

            nos[novoIndice].valor = valor;
            nos[novoIndice].proximo = inicio;
            inicio = novoIndice;
        }

        public void remover() {
            if (inicio == -1) {
                System.out.println("ERRO: Lista vazia!");
                return;
            }
            int indiceRemovido = inicio;
            inicio = nos[indiceRemovido].proximo;
            liberaNo(indiceRemovido);
        }

        public void imprimir() {
            int atual = inicio;
            System.out.print("Lista: [");
            while (atual != -1) {
                System.out.print(nos[atual].valor);
                atual = nos[atual].proximo;
                if (atual != -1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.imprimir();

        lista.remover();
        lista.imprimir();

        lista.remover();
        lista.remover();
        lista.remover();
        lista.imprimir();
    }
}
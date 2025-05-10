package org.service.Atividade8;

public class Atividade8 {

    static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    static class Lista {
        No inicio;

        public void inserir(int valor) {
            No novo = new No(valor);
            novo.proximo = inicio;
            inicio = novo;
        }

        public boolean contem(int valor) {
            No atual = inicio;
            while (atual != null) {
                if (atual.valor == valor) return true;
                atual = atual.proximo;
            }
            return false;
        }

        public static Lista uniao(Lista L1, Lista L2) {
            Lista L3 = new Lista();
            No atual = L1.inicio;

            while (atual != null) {
                if (!L3.contem(atual.valor)) {
                    L3.inserir(atual.valor);
                }
                atual = atual.proximo;
            }

            atual = L2.inicio;
            while (atual != null) {
                if (!L3.contem(atual.valor)) {
                    L3.inserir(atual.valor);
                }
                atual = atual.proximo;
            }
            return L3;
        }

        public static Lista intersecao(Lista L1, Lista L2) {
            Lista L4 = new Lista();
            No atual = L1.inicio;

            while (atual != null) {
                if (L2.contem(atual.valor) && !L4.contem(atual.valor)) {
                    L4.inserir(atual.valor);
                }
                atual = atual.proximo;
            }
            return L4;
        }

        public void imprimir() {
            No atual = inicio;
            System.out.print("Lista: ");
            while (atual != null) {
                System.out.print(atual.valor + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Lista L1 = new Lista();
        Lista L2 = new Lista();

        L1.inserir(3);
        L1.inserir(5);
        L1.inserir(7);
        L1.inserir(3);

        L2.inserir(2);
        L2.inserir(5);
        L2.inserir(8);
        L2.inserir(5);

        System.out.println("L1:");
        L1.imprimir();
        System.out.println("L2:");
        L2.imprimir();

        Lista L3 = Lista.uniao(L1, L2);
        System.out.println("\nUnião (L3):");
        L3.imprimir();

        Lista L4 = Lista.intersecao(L1, L2);
        System.out.println("Intersecção (L4):");
        L4.imprimir();
    }
}
package org.service.Atividade9;

public class Atividade9 {

    static class No {
        int valor;
        No anterior, proximo;

        No(int valor) {
            this.valor = valor;
            this.anterior = null;
            this.proximo = null;
        }
    }

    static class Lista {
        No inicio;
        No fim;

        public No locate(int pos) {
            if (pos < 1) return null;
            No atual = inicio;
            int i = 1;
            while (atual != null && i < pos) {
                atual = atual.proximo;
                i++;
            }
            return (i == pos) ? atual : null;
        }

        public boolean insereP(int valor, int pos) {
            No novo = new No(valor);
            if (pos < 1) return false;

            if (pos == 1) {
                novo.proximo = inicio;
                if (inicio != null) inicio.anterior = novo;
                inicio = novo;
                if (fim == null) fim = novo;
                return true;
            }

            No atual = locate(pos - 1);
            if (atual == null) return false;

            novo.proximo = atual.proximo;
            novo.anterior = atual;
            if (atual.proximo != null) atual.proximo.anterior = novo;
            atual.proximo = novo;
            if (novo.proximo == null) fim = novo;
            return true;
        }

        public Integer removaP(int pos) {
            No alvo = locate(pos);
            if (alvo == null) return null;

            if (alvo.anterior != null) alvo.anterior.proximo = alvo.proximo;
            else inicio = alvo.proximo;

            if (alvo.proximo != null) alvo.proximo.anterior = alvo.anterior;
            else fim = alvo.anterior;

            return alvo.valor;
        }

        public void exibir() {
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
        Lista lista = new Lista();

        lista.insereP(10, 1);
        lista.insereP(20, 2);
        lista.insereP(30, 3);
        lista.insereP(40, 4);
        lista.exibir();

        System.out.println("Elemento na posição 2: " + lista.locate(2).valor);

        lista.insereP(15, 2);
        lista.exibir();

        Integer removido = lista.removaP(3);
        System.out.println("Removido: " + removido);
        lista.exibir();
    }
}
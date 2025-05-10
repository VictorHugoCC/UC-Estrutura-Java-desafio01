package org.service.Atividade3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Atividade3 {

    private final Queue<Deque<Integer>> conjunto = new LinkedList<>();

    public void adicionar(Deque<Integer> pilha) {
        conjunto.offer(pilha);
    }

    public Deque<Integer> retirar() {
        return conjunto.poll();
    }

    public void inserirNoTopo(int valor) {
        Deque<Integer> topo = conjunto.peek();
        if (topo != null) {
            topo.push(valor);
        } else {
            System.out.println("Nenhuma pilha disponível.");
        }
    }

    public Integer removerDoTopo() {
        Deque<Integer> topo = conjunto.peek();
        if (topo != null && !topo.isEmpty()) {
            return topo.pop();
        } else {
            System.out.println("Impossível remover: fila ou pilha vazia.");
            return null;
        }
    }

    public static void main(String[] args) {
        Atividade3 sistema = new Atividade3();

        Deque<Integer> a = new ArrayDeque<>();
        a.push(7);
        a.push(14);
        sistema.adicionar(a);

        Deque<Integer> b = new ArrayDeque<>();
        b.push(21);
        b.push(28);
        sistema.adicionar(b);

        sistema.inserirNoTopo(100);

        Integer valor = sistema.removerDoTopo();
        System.out.println("Removido do topo da pilha inicial: " + valor);

        Deque<Integer> pilhaSaida = sistema.retirar();
        System.out.println("Pilha retirada da fila: " + pilhaSaida);
    }
}
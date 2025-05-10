package org.service.Atividade6;

import java.util.LinkedList;
import java.util.Queue;

public class Atividade6 {

    private static int calcularSomaElementosFila(Queue<Integer> fila) {
        Queue<Integer> copiaFila = new LinkedList<>(fila);
        int somaTotal = 0;
        while (!copiaFila.isEmpty()) {
            somaTotal += copiaFila.poll();
        }
        return somaTotal;
    }

    public static String avaliarFilas(Queue<Integer> f1, Queue<Integer> f2) {
        if (f1.equals(f2)) {
            return "As filas F1 e F2 são idênticas.";
        } else {
            int somaF1 = calcularSomaElementosFila(f1);
            int somaF2 = calcularSomaElementosFila(f2);
            if (somaF1 > somaF2) {
                return "As filas F1 e F2 não são idênticas. A fila F1 possui soma maior.";
            } else if (somaF2 > somaF1) {
                return "As filas F1 e F2 não são idênticas. A fila F2 possui soma maior.";
            } else {
                return "As filas F1 e F2 não são idênticas, mas possuem a mesma soma de elementos.";
            }
        }
    }

    public static void analisarFila(Queue<Integer> fila) {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia. Não é possível calcular estatísticas.");
            return;
        }

        Queue<Integer> filaTemporaria = new LinkedList<>(fila);
        int valorMaximo = Integer.MIN_VALUE;
        int valorMinimo = Integer.MAX_VALUE;
        long somaDosValores = 0;
        int quantidadeDeElementos = 0;

        while (!filaTemporaria.isEmpty()) {
            int elementoAtual = filaTemporaria.poll();
            if (elementoAtual > valorMaximo) {
                valorMaximo = elementoAtual;
            }
            if (elementoAtual < valorMinimo) {
                valorMinimo = elementoAtual;
            }
            somaDosValores += elementoAtual;
            quantidadeDeElementos++;
        }

        double mediaAritmetica = (double) somaDosValores / quantidadeDeElementos;

        System.out.println("Maior elemento: " + valorMaximo);
        System.out.println("Menor elemento: " + valorMinimo);
        System.out.println("Média aritmética: " + String.format("%.2f", mediaAritmetica));
    }

    public static void duplicarConteudoFila(Queue<Integer> filaOrigem, Queue<Integer> filaDestino) {
        filaDestino.clear();
        for (Integer elemento : filaOrigem) {
            filaDestino.offer(elemento);
        }
    }

    public static int obterContagemImparesFila(Queue<Integer> fila) {
        int contadorImpares = 0;
        for (Integer elemento : fila) {
            if (elemento % 2 != 0) {
                contadorImpares++;
            }
        }
        return contadorImpares;
    }

    public static int obterContagemParesFila(Queue<Integer> fila) {
        int contadorPares = 0;
        for (Integer elemento : fila) {
            if (elemento % 2 == 0) {
                contadorPares++;
            }
        }
        return contadorPares;
    }

    public static void main(String[] args) {
        Queue<Integer> filaUm = new LinkedList<>();
        Queue<Integer> filaDois = new LinkedList<>();

        filaUm.offer(10);
        filaUm.offer(25);
        filaUm.offer(30);
        filaUm.offer(45);

        filaDois.offer(10);
        filaDois.offer(20);
        filaDois.offer(30);

        System.out.println("Avaliação F1 e F2: " + avaliarFilas(filaUm, filaDois));

        Queue<Integer> filaTres = new LinkedList<>();
        filaTres.offer(10);
        filaTres.offer(25);
        filaTres.offer(30);
        filaTres.offer(45);
        System.out.println("Avaliação F1 e F3 (iguais): " + avaliarFilas(filaUm, filaTres));

        System.out.println("\nAnalisando Fila Um:");
        analisarFila(filaUm);

        System.out.println("\nAnalisando Fila Dois (após modificação para teste de estatísticas):");
        filaDois.clear();
        filaDois.offer(8);
        filaDois.offer(3);
        filaDois.offer(11);
        filaDois.offer(6);
        filaDois.offer(5);
        analisarFila(filaDois);

        System.out.println("\nCopiando Fila Um para Fila Dois:");
        System.out.println("Fila Um original: " + filaUm);
        duplicarConteudoFila(filaUm, filaDois);
        System.out.println("Fila Dois após cópia: " + filaDois);
        System.out.println("Fila Um (deve estar inalterada): " + filaUm);

        System.out.println("\nContagem em Fila Um:");
        System.out.println("Quantidade de ímpares em Fila Um: " + obterContagemImparesFila(filaUm));
        System.out.println("Quantidade de pares em Fila Um: " + obterContagemParesFila(filaUm));

        System.out.println("\nTestando com fila vazia:");
        Queue<Integer> filaVazia = new LinkedList<>();
        analisarFila(filaVazia);
        System.out.println("Ímpares em fila vazia: " + obterContagemImparesFila(filaVazia));
        System.out.println("Pares em fila vazia: " + obterContagemParesFila(filaVazia));
    }
}
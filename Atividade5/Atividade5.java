package org.service.Atividade5;

import java.util.Stack;
import java.util.Iterator;

public class Atividade5 {

    private static int calcularSomaElementos(Stack<Integer> pilha) {
        Stack<Integer> copiaPilha = (Stack<Integer>) pilha.clone();
        int somaTotal = 0;
        while (!copiaPilha.isEmpty()) {
            somaTotal += copiaPilha.pop();
        }
        return somaTotal;
    }

    public static String avaliarPilhas(Stack<Integer> p1, Stack<Integer> p2) {
        if (p1.equals(p2)) {
            return "As pilhas P1 e P2 são idênticas.";
        } else {
            int somaP1 = calcularSomaElementos(p1);
            int somaP2 = calcularSomaElementos(p2);
            if (somaP1 > somaP2) {
                return "As pilhas P1 e P2 não são idênticas. A pilha P1 possui soma maior.";
            } else if (somaP2 > somaP1) {
                return "As pilhas P1 e P2 não são idênticas. A pilha P2 possui soma maior.";
            } else {
                return "As pilhas P1 e P2 não são idênticas, mas possuem a mesma soma de elementos.";
            }
        }
    }

    public static void analisarPilha(Stack<Integer> pilha) {
        if (pilha.isEmpty()) {
            System.out.println("A pilha está vazia. Não é possível calcular estatísticas.");
            return;
        }

        Stack<Integer> pilhaTemporaria = (Stack<Integer>) pilha.clone();
        int valorMaximo = Integer.MIN_VALUE;
        int valorMinimo = Integer.MAX_VALUE;
        long somaDosValores = 0;
        int quantidadeDeElementos = 0;

        if (!pilhaTemporaria.isEmpty()){
            valorMaximo = pilhaTemporaria.peek();
            valorMinimo = pilhaTemporaria.peek();
        }

        while (!pilhaTemporaria.isEmpty()) {
            int elementoAtual = pilhaTemporaria.pop();
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

    public static void duplicarPilhaConteudo(Stack<Integer> pilhaFonte, Stack<Integer> pilhaDestino) {
        pilhaDestino.clear();
        Stack<Integer> auxiliar = new Stack<>();

        Stack<Integer> cloneFonte = (Stack<Integer>) pilhaFonte.clone();

        while(!cloneFonte.isEmpty()){
            auxiliar.push(cloneFonte.pop());
        }

        while(!auxiliar.isEmpty()){
            pilhaDestino.push(auxiliar.pop());
        }
    }

    public static int obterContagemImpares(Stack<Integer> pilha) {
        int contadorImpares = 0;
        for (Integer elemento : pilha) {
            if (elemento % 2 != 0) {
                contadorImpares++;
            }
        }
        return contadorImpares;
    }

    public static int obterContagemPares(Stack<Integer> pilha) {
        int contadorPares = 0;
        Iterator<Integer> iterador = pilha.iterator();
        while(iterador.hasNext()){
            if(iterador.next() % 2 == 0){
                contadorPares++;
            }
        }
        return contadorPares;
    }

    public static void main(String[] args) {
        Stack<Integer> pilhaA = new Stack<>();
        Stack<Integer> pilhaB = new Stack<>();

        pilhaA.push(5);
        pilhaA.push(15);
        pilhaA.push(25);
        pilhaA.push(30);

        pilhaB.push(10);
        pilhaB.push(20);
        pilhaB.push(30);

        System.out.println("Avaliação P1 e P2: " + avaliarPilhas(pilhaA, pilhaB));

        Stack<Integer> pilhaC = new Stack<>();
        pilhaC.push(5);
        pilhaC.push(15);
        pilhaC.push(25);
        pilhaC.push(30);
        System.out.println("Avaliação P1 e P3 (iguais): " + avaliarPilhas(pilhaA, pilhaC));


        System.out.println("\nAnalisando Pilha A:");
        analisarPilha(pilhaA);

        System.out.println("\nAnalisando Pilha B (após modificação para teste de estatísticas):");
        pilhaB.clear();
        pilhaB.push(7);
        pilhaB.push(2);
        pilhaB.push(9);
        pilhaB.push(4);
        pilhaB.push(5);
        analisarPilha(pilhaB);

        System.out.println("\nCopiando Pilha A para Pilha B:");
        System.out.println("Pilha A original: " + pilhaA);
        duplicarPilhaConteudo(pilhaA, pilhaB);
        System.out.println("Pilha B após cópia: " + pilhaB);
        System.out.println("Pilha A (deve estar inalterada): " + pilhaA);


        System.out.println("\nContagem em Pilha A:");
        System.out.println("Quantidade de ímpares em Pilha A: " + obterContagemImpares(pilhaA));
        System.out.println("Quantidade de pares em Pilha A: " + obterContagemPares(pilhaA));

        System.out.println("\nTestando com pilha vazia:");
        Stack<Integer> pilhaVazia = new Stack<>();
        analisarPilha(pilhaVazia);
        System.out.println("Ímpares em pilha vazia: " + obterContagemImpares(pilhaVazia));
        System.out.println("Pares em pilha vazia: " + obterContagemPares(pilhaVazia));
    }
}
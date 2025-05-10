package org.service.Atividade2;

import java.util.Stack;

public class Atividade2 {

    public static void main(Stack<Integer> pilha) {
        if (pilha == null || pilha.isEmpty()) {
            return;
        }

        Stack<Integer> pilhaAuxiliar = new Stack<>();

        while (!pilha.isEmpty()) {
            int temp = pilha.pop();

            while (!pilhaAuxiliar.isEmpty() && pilhaAuxiliar.peek() > temp) {
                pilha.push(pilhaAuxiliar.pop());
            }
            pilhaAuxiliar.push(temp);
        }

        while (!pilhaAuxiliar.isEmpty()) {
            pilha.push(pilhaAuxiliar.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> minhaPilha = new Stack<>();
        minhaPilha.push(10);
        minhaPilha.push(3);
        minhaPilha.push(9);
        minhaPilha.push(8);
        minhaPilha.push(2);
        minhaPilha.push(23);

        System.out.println("Pilha original: " + minhaPilha);

        main(minhaPilha);

        System.out.println("Pilha ordenada em ordem crescente (do topo para a base): " + minhaPilha);

    }
}
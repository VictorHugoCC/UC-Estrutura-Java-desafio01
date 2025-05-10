package org.service.Atividade1;

import java.util.Stack;

public class Atividade1 {
    public static String inverterPalavras(String texto) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder resultado = new StringBuilder();

        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                pilha.push(c);
            } else {
                while (!pilha.isEmpty()) {
                    resultado.append(pilha.pop());
                }
                resultado.append(c);
            }
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        String entrada = "ESTE EXERCÍCIO É MUITO FÁCIL.";
        System.out.println(inverterPalavras(entrada));
    }
}
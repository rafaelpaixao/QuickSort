
/*
    Como esse código funciona:

    Primeiro, crie um vetor de inteiros.
    Existe uma função que retorna um vetor de inteiros aleatórios,
    basta informar o tamanho do vetor e a amplitude dos valores.
    
    Em seguida, chame a função quickSort passando esse vetor.
    A função pode realizar até 2 chamadas recurssivas.
    
    Para cada iteração, são impressos no console:
    - Qual a iteração atual;
    - Vetor recebido na iteração
    - As trocas realizadas;
    - Vetor resultado da iteração;
*/



package quicksort;

import java.util.Random;

public class QuickSort {

    static Random aleatorio = new Random();
    static int contIteracoes = 0;

    public static void main(String[] args) {
        
        //Cria um vetor com 10 números inteiros aleatórios entre 0 e 50
        int[] vetor = gerarVetorAleatorio(10, 50);

        imprimirVetor(vetor);

        quickSort(vetor, 0, vetor.length - 1);

        imprimirVetor(vetor);
    }

    public static void quickSort(int vetor[], int indexInicial, int indexFinal) {
        int indexPivo = (indexInicial + indexFinal) / 2;
        int valorPivo = vetor[indexPivo];
        int aux;
        int i = indexInicial;
        int j = indexFinal;

        System.out.println("\nIteração: " + ++contIteracoes);
        System.out.print("Vetor recebido: ");
        imprimirVetor(vetor);
        System.out.println("Pivo: " + valorPivo);

        while (i < indexPivo && j > indexPivo) {
            while (vetor[j] >= valorPivo && j > indexPivo) {
                j--;
            }
            while (vetor[i] <= valorPivo && i < indexPivo) {
                i++;
            }
            if (i < j) {
                System.out.println("Trocando: " + vetor[i] + " com " + vetor[j]);
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
        }

        System.out.print("Vetor entregue: ");
        imprimirVetor(vetor);

        if (indexInicial < indexPivo - 1) {
            quickSort(vetor, indexInicial, indexPivo - 1);
        }
        if (indexFinal > indexPivo + 1) {
            quickSort(vetor, indexPivo + 1, indexFinal);
        }
    }
    
    public static void imprimirVetor(int vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("");
    }

    public static int[] gerarVetorAleatorio(int tamanho, int limite) {
        int[] v = new int[tamanho];

        for (int i = 0; i < v.length; i++) {
            v[i] = aleatorio.nextInt(limite);
        }

        return v;
    }

}

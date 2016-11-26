package quicksort;

import java.util.Random;

public class QuickSort {

    static Random aleatorio = new Random();
    static int contIteracoes = 0;

    public static void main(String[] args) {
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

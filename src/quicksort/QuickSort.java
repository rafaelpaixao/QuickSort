/*
    Como esse código funciona:

    Primeiro, crie um vetor de inteiros.
    Existe uma função que retorna um vetor de inteiros aleatórios,
    basta informar o tamanho do vetor e a amplitude dos valores.
    
    Em seguida, chame a função quickSort passando esse vetor.
    A função pode realizar até 2 chamadas recurssivas.
    
    Para cada iteração, são impressos no console:
    - Qual a iteração atual;
    - Quem é o pivô;
    - Vetor recebido na iteração;
    - As trocas realizadas;
    - Vetor antes da troca;
    - Vetor depois da troca;
*/


package quicksort;

import java.util.Random;

public class QuickSort {

    static Random aleatorio = new Random();
    static int contIteracoes = 0;
    static int[] vetor = gerarVetorAleatorio(20, 50);
    static int[] posicoes = gerarVetorDePosicoes(20);

    public static void main(String[] args) {
        
        //Cria um vetor com números inteiros aleatórios
        quickSort(vetor, 0, vetor.length - 1);
        
        System.out.println("\n\n\nVetor Ordenado:");
        imprimirVetor(vetor,-1,-1);
    }

    public static void quickSort(int vetor[], int indexInicial, int indexFinal) {
        int indexPivo = (indexInicial + indexFinal) / 2;
        int valorPivo = vetor[indexPivo];
        int aux;
        int i = indexInicial;
        int j = indexFinal;

        System.out.println("\n\n\nIteração: " + ++contIteracoes);
        System.out.println("Pivô: " + valorPivo);
        System.out.println("Vetor recebido:");
        imprimirVetor(vetor,indexPivo,-1);
        

        while (i < indexPivo && j > indexPivo) {
            while (vetor[j] >= valorPivo && j > indexPivo) {
                j--;
            }
            while (vetor[i] <= valorPivo && i < indexPivo) {
                i++;
            }
            if (i < j) {
                System.out.println("\nTrocando: " + vetor[i] + " com " + vetor[j]);
                imprimirVetor(posicoes,i,j);
                imprimirVetor(vetor,i,j);
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                imprimirVetor(vetor,i,j);
            }
        }
        System.out.println("---Fim da iteração---");
        if (indexInicial < indexPivo - 1) {
            quickSort(vetor, indexInicial, indexPivo - 1);
        }
        if (indexFinal > indexPivo + 1) {
            quickSort(vetor, indexPivo + 1, indexFinal);
        }
    }
    
    public static void imprimirVetor(int vetor[],int a, int b) {
        for (int i = 0; i < vetor.length; i++) {
            if(i==a || i==b) System.out.print("|");
            if(vetor[i]<10) System.out.print(" ");
            System.out.print(vetor[i]);
            if(i==a || i==b) System.out.print("|");
            System.out.print(" ");
            
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
    
    public static int[] gerarVetorDePosicoes(int tamanho){
        int[] v = new int[tamanho];

        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }

        return v;
    }
}

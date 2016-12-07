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

    static final int TAMANHO = 15; //TAMANHO DO VETOR
    static final int AMPLITUDE = 50; //MAIOR VALOR ALEATORIO
    
    static Random aleatorio = new Random();
    static int contIteracoes = 0;
    static int contTabs = 0;
    static int[] vetor = gerarVetorAleatorio(TAMANHO, AMPLITUDE);
    
    static int contTrocas = 0;

    public static void main(String[] args) {
        
        int [] desordenado = new int[TAMANHO];
        for(int i=0; i<TAMANHO; i++){
            desordenado[i] = vetor[i];
        }
        
        quickSort(vetor, 0, vetor.length - 1);
        
        System.out.print("\n\nVETOR ORIGINAL:");
        System.out.println(vetorParaString(desordenado));
        System.out.print("VETOR ORDENADO:");
        System.out.println(vetorParaString(vetor));
        System.out.println("Total de trocas: "+contTrocas);
        System.out.println("Total de iterações: "+contIteracoes);
    }

    public static void quickSort(int[] vetor, int indexInicial, int indexFinal) {
        int iteracaoAtual = ++contIteracoes;
        System.out.println("");
        escreve("Iteração: " + iteracaoAtual);
        contTabs++;
        if (indexInicial < indexFinal) {
            int q = particao(vetor, indexInicial, indexFinal);
            quickSort(vetor, indexInicial, q);
            quickSort(vetor, q+1, indexFinal);
        }
        contTabs--;
        System.out.println("");
        escreve("Fim da Iteração: " + iteracaoAtual);
    }
    
    public static int particao(int[] vetor, int indexInicial, int indexFinal) {
        int indexPivo = (indexInicial+indexFinal)/2;
        int pivo = vetor[indexPivo];
        int i = indexInicial-1;
        int j = indexFinal+1;
        
        while (i < j) {
            
            do
                j--;
            while(vetor[j]>pivo);
            
            do
                i++;
            while(vetor[i]<pivo);
            
            if(i < j)
                troca(vetor, i, j);
        }
        
        return j;
    }

    public static void troca(int[] vetor, int a, int b) {
        contTrocas++;
        escreve("Trocando posição " + a + " com " + b);
        escreve("Antes:  ");
        escreve(vetorParaString(vetor, a, b));
        int aux = vetor[a];
        vetor[a] = vetor[b];
        vetor[b] = aux;
        escreve("Depois: ");
        escreve(vetorParaString(vetor, a, b));
    }

    public static String vetorParaString(int vetor[]) {
        String s = "";
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < 10)
                s += " ";
            s += ""+ vetor[i];
            s += " ";
        }
        return s;
    }
    
    public static String vetorParaString(int vetor[], int a, int b) {
        String s = "";
        for (int i = 0; i < vetor.length; i++) {
            if (i == a || i == b)
                s += "|";
            if (vetor[i] < 10)
                s += " ";
            s += ""+ vetor[i];
            if (i == a || i == b)
                s += "|";
            s += " ";
        }
        return s;
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
        for (int i = 0; i < v.length; i++)
            v[i] = i;
        return v;
    }
    
    public static void escreve(String a){
        System.out.println();
        for(int i=0;i<contTabs;i++){
            System.out.print("   ");
        }
        System.out.print(a);
    }
}

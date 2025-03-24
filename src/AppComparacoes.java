import java.util.Arrays;
import java.util.Random;

public class AppComparacoes {
    
    static Random aleatorio = new Random(42);

    static Integer[] gerarVetor(int tamanho){
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
    }

    static <T extends Comparable<T>> T[] testar(IOrdenador<T> algoritmo, T[] vetor){
        T[] resp = algoritmo.ordenar(vetor);
        System.out.printf("Tamanho: %,d\n", vetor.length);
        System.out.printf("Tempo: %,.2f milissegundos\n", algoritmo.getTempoOrdenacao());
        System.out.printf("Comparações: %,d\n", algoritmo.getComparacoes());
        System.out.printf("Movimentações: %,d\n",algoritmo.getMovimentacoes());
        return resp;
    }

	public static void main(String[] args) throws Exception {
		int[] tamanhosTeste =   { 7_812, 15_625, 31_250, 62_500, 100_000};
        
        for(int i = 0; i < tamanhosTeste.length; i++){
            Integer[] vetor = gerarVetor(tamanhosTeste[i]);
            
            System.out.println("\n=====================");
            System.out.println("Bubble");
            testar(new BubbleSort<Integer>(), vetor);
    
            System.out.println();
            System.out.println("Insert");
            testar(new Insercao<Integer>(), vetor);
    
            System.out.println();
            System.out.println("Merge");
            testar(new Mergesort<Integer>(), vetor);
        }
        
    }
}

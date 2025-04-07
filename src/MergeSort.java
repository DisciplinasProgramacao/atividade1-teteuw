import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T extends Comparable<T>> implements IOrdenador<T> {

    private long comparacoes;
        private long movimentacoes;
        private LocalDateTime inicio;
        private LocalDateTime termino;
        private T[] dadosOrdenados;
        
        public MergeSort() {
            comparacoes = 0;
            movimentacoes = 0;
        }
         
        @Override
        public T[] ordenar(T[] dados) {    
            return ordenar(dados, T::compareTo);
        }
    

        private T[] ordenar(T[] dados, Comparator<T> comparador){
            T[] novo = Arrays.copyOf(dados, dados.length);
            inicio = LocalDateTime.now();
            
            int meio = (inicio+fim)/2;
            int indice1 = inicio;
            int indice2 = meio+1;
            int pos = inicio;
            while(indice1 <= meio && indice2 <= fim){
                comparacoes++;
                
                if(dados[indice1].compareTo(dados[indice2]) <=0)
                    novo[pos] = dados[indice1++];
                else
                    novo[pos] = dados[indice2++];
                
                pos++;
                movimentacoes++;
            }
            int origem = indice1;
            int destino = meio;
           
            if(indice1 > meio){
                origem = indice2;
                destino = fim;
            }
           
            for(int i = origem; i<=destino; i++){
                novo[pos++] = dados[i];
                movimentacoes++;
            }
            return novo;
        }
}

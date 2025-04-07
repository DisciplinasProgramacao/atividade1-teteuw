import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T extends Comparable<T>> implements IOrdenador<T> {

    private long comparacoes;
        private long movimentacoes;
        private LocalDateTime inicio;
        private LocalDateTime termino;
        
        public MergeSort() {
            comparacoes = 0;
            movimentacoes = 0;
        }
         
        @Override
        public T[] ordenar(T[] dados) {    
            return ordenar(dados, T::compareTo);
        }
    

        public T[] ordenar(T[] dados, Comparator<T> comparador){

            T[] novo = Arrays.copyOf(dados, dados.length);
            inicio = LocalDateTime.now();
            int fim = novo.length;
            int meio = novo.length/2;
            int indice1 = 0;
            int indice2 = meio+1;
            int pos = 0;
            while(indice1 <= meio && indice2 <= fim){
                comparacoes++;
                
                if(comparador.compare(dados[indice1], (dados[indice2])) <=0)
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
            termino = LocalDateTime.now();
            return novo;
        }

        @Override
        public long getComparacoes() {
            return comparacoes;
        }

        @Override
        public long getMovimentacoes() {
            return movimentacoes;
        }

        @Override
        public double getTempoOrdenacao() {
            return  Duration.between(inicio, termino).toMillis();
        }
}

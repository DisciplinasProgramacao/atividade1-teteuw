import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> implements IOrdenador<T> {
    private long comparacoes;
    private long movimentacoes;
    private LocalDateTime inicio, fim;

    @Override
    public T[] ordenar(T[] dados) {
        T[] copiaDados = Arrays.copyOf(dados, dados.length);
        int tamanho = copiaDados.length;
        comparacoes = movimentacoes = 0;
        inicio = LocalDateTime.now();
        for(int posReferencia = tamanho - 1; posReferencia > 0; posReferencia--){
            for(int posicao = 0; posicao < posReferencia; posicao ++){
                comparacoes++;
                if(copiaDados[posicao].compareTo(copiaDados[posicao+1]) > 0){
                    trocar(posicao, posicao + 1, copiaDados);
                }
            }
        }
        fim = LocalDateTime.now();
        return copiaDados;
    }
    private void trocar(int p1, int p2, T[] dados){
        movimentacoes+=3;
        T temp = dados[p1];
        dados[p1] = dados[p2];
        dados[p2] = temp;
    }

    @Override
    public long getComparacoes() {
        return this.comparacoes;
    }

    @Override
    public long getMovimentacoes() {
        return this.movimentacoes;
    }

    @Override
    public double getTempoOrdenacao() {
        return Duration.between(inicio, fim).toMillis();
    }
    
}

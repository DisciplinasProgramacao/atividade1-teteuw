import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Insercao<T extends Comparable<T>> implements IOrdenador<T>{

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
            T valor = copiaDados[posReferencia];
            int j = posReferencia - 1;
            comparacoes++;
            while(j >= 0 && valor.compareTo(copiaDados[j])<0){
                j--;
                comparacoes++;
            }
            copiarDados(j+1, posReferencia, copiaDados);
            copiaDados[j+1] = valor;
            movimentacoes+=2;
        }
        fim = LocalDateTime.now();
        return copiaDados;
    }

    private void copiarDados(int inicio, int fim, T[] vet){
        for(int i = fim; i > inicio; i--){
            movimentacoes++;
            vet[i] = vet[i-1];
        }
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

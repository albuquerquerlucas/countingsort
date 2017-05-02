import java.util.Arrays;

public class CountingSort {
	
	int vetor[] = {};
	int aux[] = {};
	int resposta[] = {};
	int indiceMaiorValor = 0;
	
	public CountingSort(int[] v) {
		
		// Recebe o vetor passado.
		this.vetor = v;
		
		// Atibui o �ncide de maior valor.
		this.indiceMaiorValor = getIndiceDoMaiorValor(vetor);
		
		// Cria um vetor auxiliar com tamanho do maior elemento do vetor + 1
		this.aux = new int[vetor[indiceMaiorValor] + 1];
		
		// Cria um vetor resposta do mesmo tamanho do vetor.
		this.resposta = new int[vetor.length];
		
		// Preenchimento do vetor auxiliar com '0' (zero).
		for(int i = 0; i < aux.length; i++){
			aux[i] = 0;
		}
		
		// Percorre o vetor principal e cada valor encontrado ele incrementa 1 (um) no �ndice correspondente no vetor aux.
		for(int i = 0; i < vetor.length; i++){
			aux[vetor[i]]+= 1;
		}
		
		// Soma o valor do �ndice 1 (um) com o valor do �ndice anterior, o valor do �ndice 2 (dois) com o anterior at� o final do aux.
		for(int i = 1; i < aux.length; i++){
			aux[i]+= aux[i - 1];
		}
		
		// Usa o valor do vetor principal como �ndice no aux, pegando o valor desse �ndice e usando �ndice - 1 
		// para inserir o valor do vetor na exata posi��o na resposta, depois decrementa aux[i]
		for(int i = 0; i < vetor.length; i++){
			this.resposta[aux[aux[vetor[i]-- - 1]]] = vetor[i];
		}
		
		// Copia o resposta para o vetor principal.
		for(int i = 0; i < vetor.length; i++){
			vetor[i] = resposta[i];
		}
	}
	
	// Busca o �ndice do maior valor.
	public int getIndiceDoMaiorValor(int[] v){
		int m = 0;
		for(int i = 0; i < v.length; i++){
			if(v[i] > v[m]){
				m = i;
			}
		}
		return m;
	}
	
	// Exibe o vetor depois de ordenado.
	public void exibeVetor(){
		
		System.out.println(Arrays.toString(vetor));
	}
}

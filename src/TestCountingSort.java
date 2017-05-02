
public class TestCountingSort {

	public static void main(String[] args) {
		
		// Vetor desordenado.
		int[] vetor = {1, 8, 3, 4, 6, 7, 2, 5};
		
		
		CountingSort cs = new CountingSort(vetor);
		cs.exibeVetor();
	}
}

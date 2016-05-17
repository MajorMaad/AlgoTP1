package tri;

/**
 * Classe contenant l'algorithme de tri à bulles
 * @author Quentin Audinot
 *
 */
public class TriTas {

	/**
	 * Fonction de tri par tas
	 * @param tab : le tableau à trier
	 * @param inverse : true si on veut trier le tableau de façon inverse
	 * @return le tableau trié
	 */
	public static int[] triParTas(int[] tab) {
		int[] tabTrie = new int[tab.length];
		System.arraycopy(tab, 0, tabTrie, 0, tab.length);
		
		int n = tabTrie.length;
		
		for (int i=n/2; i>=0; i--) {
			tamiser(tabTrie, i, n-1);
		}
		
		for (int i=n-1; i>0; i--) {
			int tamp = tabTrie[i];
			tabTrie[i] = tabTrie[0];
			tabTrie[0] = tamp;
			tamiser(tabTrie, 0, i-1);
		}
		
		return tabTrie;
	}
	
	private static void tamiser(int[] tab, int noeud, int n) {
		int k = noeud;
		int j = 2*k;
		
		while (j<=n) {
			if (j<n && tab[j]<tab[j+1])
				j++;
			if (tab[k]<tab[j]) {
				int tamp = tab[k];
				tab[k] = tab[j];
				tab[j] = tamp;
				k = j;
				j = 2*k;
			}
			else break;
		}
	}
	
}

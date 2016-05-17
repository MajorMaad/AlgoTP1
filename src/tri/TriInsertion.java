package tri;

/**
 * Classe contenant l'algorithme de tri par insertion
 * @author Quentin Audinot
 *
 */
public class TriInsertion {
	
	/**
	 * Fonction de tri par insertion
	 * @param tab : le tableau à trier
	 * @param inverse : true si on veut trier le tableau de façon inverse
	 * @return le tableau trié
	 */
	public static int[] triInsertion(int[] tab) {
		int[] tabTrie = new int[tab.length];
		System.arraycopy(tab, 0, tabTrie, 0, tab.length);
		
		for (int i=1; i<=tabTrie.length-1; i++) {
			int x = tabTrie[i];
			int j = i;
			
			while (j>0 && tabTrie[j-1] > x) {
				tabTrie[j] = tabTrie[j-1];
				j--;
			}
			tabTrie[j] = x;
		}
		
		return tabTrie;
	}

}

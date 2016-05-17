package tri;

/**
 * Classe contenant l'algorithme de tri à bulles
 * @author Quentin Audinot
 *
 */
public class TriBulles {
	
	/**
	 * Fonction de tri à bulles
	 * @param tab : le tableau à trier
	 * @param inverse : true si on veut trier le tableau de façon inverse
	 * @return le tableau trié
	 */
	public static int[] triBulles(int[] tab) {
		int[] tabTrie = new int[tab.length];
		System.arraycopy(tab, 0, tabTrie, 0, tab.length);
		
		boolean tab_en_ordre = false;
		int taille = tabTrie.length;
		
		while(!tab_en_ordre) {
			tab_en_ordre = true;
			for (int i=0; i<taille-1; i++) {
				if (tabTrie[i] > tabTrie[i+1]) {
					int tamp = tabTrie[i];
					tabTrie[i] = tabTrie[i+1];
					tabTrie[i+1] = tamp;
					tab_en_ordre = false;
				}
			}
			taille--;
		}
		
		return tabTrie;
	}

}

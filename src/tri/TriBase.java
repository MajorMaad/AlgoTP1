package tri;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe contenant l'algorithme de tri par base
 * @author Quentin Audinot
 *
 */
public class TriBase {
	
	/**
	 * Fonction de tri par base
	 * @param tab : le tableau à trier
	 * @param inverse : true si on veut trier le tableau de façon inverse
	 * @return : le tableau trié
	 */
	public static int[] triBase(int[] tab) {
		int[] tabTrie = new int[tab.length];
		System.arraycopy(tab, 0, tabTrie, 0, tab.length);
		
		final int RADIX = 10;
		List<Integer>[] paquets = new ArrayList[RADIX];
		for (int i=0; i<paquets.length; i++) {
			paquets[i] = new ArrayList<Integer>();
		}
		
		boolean maxLength = false;
		int tmp = -1;
		int placement = 1;
		while(!maxLength) {
			maxLength = true;
			for (Integer i : tabTrie) {
				tmp = i/placement;
				paquets[tmp%RADIX].add(i);
				if (maxLength && tmp > 0)
					maxLength = false;
			}
		
			int a = 0;
			for (int b=0; b<RADIX; b++) {
				for (Integer i : paquets[b]) {
					tabTrie[a++] = i;
				}
				paquets[b].clear();
			}
			placement *= RADIX;
		}
		
		return tabTrie;
	}
	
}

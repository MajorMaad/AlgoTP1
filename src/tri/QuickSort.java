package tri;

import java.util.Random;

/**
 * Classe contenant l'algorithme de tri rapide (QuickSort) avec choix de pivot aléatoire ou non
 * @author Quentin Audinot
 *
 */
public class QuickSort {
	
	// Fonction qui va simplement créer une copie du tableau à trier (pour pas que celui-ci ne soit modifié)
	// et appliquer l'algorithme de QuickSort sur le tableau créé, afin de le retourner par la suite
	public static int[] sort(int[] tab, boolean random) {
		int[] tabTrie = new int[tab.length];
		System.arraycopy(tab, 0, tabTrie, 0, tab.length);
		
		quickSort(tabTrie, 0, tabTrie.length-1, random);
		
		return tabTrie;
	}
	
	/**
	 * Fonction de tri rapide
	 * @param tab : Tableau à trier
	 * @param gauche : premier index
	 * @param droite : dernier index
	 * @param inverse : true si on veut trier le tableau de façon inverse
	 * @param random : true si on veut que le pivot soit choisi de façon aléatoire
	 */
	private static void quickSort(int[] tab, int gauche, int droite, boolean random) {		
		int i = gauche;
		int j = droite;
		int pivot;
		
		if (random) {
			Random r = new Random();
			pivot = tab[gauche + r.nextInt(droite-gauche)];
		}
		else 
			pivot = tab[gauche+(droite-gauche)/2];
		
		while (i<=j) {
			while (tab[i] < pivot) {
				i++;
			}
			while (tab[j] > pivot) {
				j--;
			}
			if (i<=j) {
				int tamp = tab[i];
				tab[i] = tab[j];
				tab[j] = tamp;
				i++;
				j--;
			}
		}
		
		if (gauche<j) quickSort(tab, gauche, j, random);
		if (droite>i) quickSort(tab, i, droite, random);		
	}
	
}

package tri;

/**
 * 
 * @author Quentin Audinot
 * Classe contenant l'algorithme de tri par fusion
 * 
 */
public class TriFusion {

	/**
	 * Fonction de tri par fusion
	 * @param tab : le tableau à trier
	 * @param inverse : true si on veut trier le tableau de façon inverse
	 * @return le tableau trié
	 */
	public static int[] triFusion(int[] tab) {
		int taille = tab.length;
		if (taille <= 1) return tab;
		else {
			int milieu = taille/2;
			int[] gauche = copie(tab, 0, milieu-1);
			int[] droite = copie(tab, milieu, taille-1);
			return fusion(triFusion(gauche), triFusion(droite));
		}
	}
	
	// Copie une partie du tableau tab (de debut à fin) dans un nouveau tableau
	private static int[] copie(int[] tab, int debut, int fin) {
		int[] copie = new int[fin-debut+1];
		for (int i=debut; i<=fin; i++) {
			copie[i-debut] = tab[i];
		}
		return copie;
	}
	
	// Fonction qui retourne un tableau trié : la fusion de A et B (triés récursivement) 
	private static int[] fusion(int[] A, int[] B) {
		int tailleA = A.length;
		int tailleB = B.length;
		int[] fusion = new int[tailleA+tailleB];
		int i_a = 0;
		int i_b = 0;
		int i;
		for (i=0; i_a<tailleA && i_b<tailleB; i++) {
			if (A[i_a] <= B[i_b])
				fusion[i] = A[i_a++];
			else
				fusion[i] = B[i_b++];
		}
		
		while (i_a < tailleA)
			fusion[i++] = A[i_a++];
		while(i_b < tailleB)
			fusion[i++] = B[i_b++];
		
		return fusion;
	}
}

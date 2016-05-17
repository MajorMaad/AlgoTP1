package tri;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestTri {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = -1;
		
		while (c != 0) {
			System.out.println("Choix de l'algorithme à tester :");
			System.out.println("\t1 - Tri par fusion");
			System.out.println("\t2 - Tri par bulles");
			System.out.println("\t3 - QuickSort");
			System.out.println("\t4 - QuickSort Random");
			System.out.println("\t5 - Tri par insertion");
			System.out.println("\t6 - Tri par tas");
			System.out.println("\t7 - Tri par base");
			System.out.println("\t8 - Arrays.sort()");
			System.out.println("\t0 - Quitter");
			c = sc.nextInt();
			if (c == 0) break;
			else if (c <= 0 || c >= 9) continue;
			
			System.out.println("Taille du tableau : ");
			int n = sc.nextInt();
			int tab1[] = new int[n];
			int tab2[] = new int[2*n];
			int tab3[] = new int[3*n];
			int tab5[] = new int[5*n];
			int tab7[] = new int[7*n];
			int tab10[] = new int[10*n];
			int tab100[] = new int[100*n];
			Random random = new Random();
			
			int max_val = (c == 7) ? 1400000000 : Integer.MAX_VALUE; // Integer.MAX_VALUE est trop grand pour le tri par base
			for (int i=0; i<tab1.length; i++) tab1[i] = random.nextInt(max_val);
			for (int i=0; i<tab2.length; i++) tab2[i] = random.nextInt(max_val);
			for (int i=0; i<tab3.length; i++) tab3[i] = random.nextInt(max_val);
			for (int i=0; i<tab5.length; i++) tab5[i] = random.nextInt(max_val);
			for (int i=0; i<tab7.length; i++) tab7[i] = random.nextInt(max_val);
			for (int i=0; i<tab10.length; i++) tab10[i] = random.nextInt(max_val);
			for (int i=0; i<tab100.length; i++) tab100[i] = random.nextInt(max_val);
			
			System.out.println("\nDébut des tests : ");
			long resultatsN = 0;
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab1, c);
				long fin = System.currentTimeMillis();
				resultatsN += (fin-debut);
			}
			System.out.println("Résultats pour n : " + resultatsN/10);
			long resultats2N = 0;
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab2, c);
				long fin = System.currentTimeMillis();
				resultats2N += (fin-debut);
			}
			System.out.println("Résultats pour 2n : " + resultats2N/10);
			long resultats3N = 0;
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab3, c);
				long fin = System.currentTimeMillis();
				resultats3N += (fin-debut);
			}
			System.out.println("Résultats pour 3n : " + resultats3N/10);
			long resultats5N = 0;
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab5, c);
				long fin = System.currentTimeMillis();
				resultats5N += (fin-debut);
			}
			System.out.println("Résultats pour 5n : " + resultats5N/10);
			long resultats7N = 0;
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab7, c);
				long fin = System.currentTimeMillis();
				resultats7N += (fin-debut);
			}
			System.out.println("Résultats pour 7n : " + resultats7N/10);
			long resultats10N = 0;
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab10, c);
				long fin = System.currentTimeMillis();
				resultats10N += (fin-debut);
			}
			System.out.println("Résultats pour 10n : " + resultats10N/10);
			long resultats100N = 0;
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab100, c);
				long fin = System.currentTimeMillis();
				resultats100N += (fin-debut);
			}
			System.out.println("Résultats pour 100n : " + resultats100N/10);
			long resultats10Ntrie = 0;
			Arrays.sort(tab10);
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab10, c);
				long fin = System.currentTimeMillis();
				resultats10Ntrie += (fin-debut);
			}
			System.out.println("Résultats pour 10n trié : " + resultats10Ntrie/10);
			long resultats100Ntrie = 0;
			Arrays.sort(tab100);
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = TriFusion.triFusion(tab100);
				long fin = System.currentTimeMillis();
				resultats100Ntrie += (fin-debut);
			}
			System.out.println("Résultats pour 100n trié : " + resultats100Ntrie/10);
			long resultats10NtrieInverse = 0;
			for (int i = 0; i < tab10.length / 2; i++) {
			  int temp = tab10[i];
			  tab10[i] = tab10[tab10.length - 1 - i];
			  tab10[tab10.length - 1 - i] = temp;
			}
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab10, c);
				long fin = System.currentTimeMillis();
				resultats10NtrieInverse += (fin-debut);
			}
			System.out.println("Résultats pour 10n trié inversé : " + resultats10NtrieInverse/10);
			long resultats100NtrieInverse = 0;
			for (int i = 0; i < tab100.length / 2; i++) {
			  int temp = tab100[i];
			  tab100[i] = tab100[tab100.length - 1 - i];
			  tab100[tab100.length - 1 - i] = temp;
			}
			for (int i=0; i<10; i++) {
				long debut = System.currentTimeMillis();
				int[] tabTrie = trie(tab100, c);
				long fin = System.currentTimeMillis();
				resultats100NtrieInverse += (fin-debut);
			}
			System.out.println("Résultats pour 100n trié inversé : " + resultats100NtrieInverse/10);
			System.out.println();
		}		
	}
	
	private static int[] trie(int[] tab, int algo) {
		switch (algo) {
		case 1: return TriFusion.triFusion(tab);
		case 2: return TriBulles.triBulles(tab);
		case 3: return QuickSort.sort(tab, false);
		case 4: return QuickSort.sort(tab, true);
		case 5: return TriInsertion.triInsertion(tab);
		case 6: return TriTas.triParTas(tab);
		case 7: return TriBase.triBase(tab);
		case 8:
			int[] newTab = new int[tab.length];
			System.arraycopy(tab, 0, newTab, 0, tab.length);
			Arrays.sort(newTab);
			return newTab;

		default: return null;
		}
	}

}

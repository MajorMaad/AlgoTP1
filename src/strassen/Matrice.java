package strassen;

import java.util.Random;

/**
 * 
 * @author Quentin Audinot
 * Classe représentant une Matrice carrée d'ordre n
 * Celle-ci permet d'effectuer des opérations basiques sur les matrices
 * ainsi que la mutliplication de 2 matrices avec l'algorithme de Strassen
 *
 */
public class Matrice {
	
	private int n; // Ordre de la matrice
	private int[][] donnees;
	
	public Matrice(int n) {
		this.n = n;
		this.donnees = new int[n][n];
	}
	
	// Additions de 2 matrices
	public static Matrice additionner(Matrice A, Matrice B) {
		if (A.n != B.n) throw new RuntimeException("Impossible d'additionner deux matrices de dimensions différentes.");
		int n = A.n;
		Matrice C = new Matrice(n);
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				C.donnees[i][j] = A.donnees[i][j] + B.donnees[i][j];
		return C;
	}
	
	// Soustraction de 2 matrices
	public static Matrice soustraire(Matrice A, Matrice B) {
		if (A.n != B.n) throw new RuntimeException("Impossible de soustraire deux matrices de dimensions différentes.");
		int n = A.n;
		Matrice C = new Matrice(n);
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				C.donnees[i][j] = A.donnees[i][j] - B.donnees[i][j];
		return C;
	}
	
	// Multiplication naïve de 2 matrices
	public static Matrice multiplier(Matrice A, Matrice B) {
		if (A.n != B.n) throw new RuntimeException("Impossible de multiplier deux matrices de dimensions différentes.");
		int n = A.n;
		Matrice C = new Matrice(n);
		C.remplissage();
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				for (int k=0; k<n; k++)
					C.donnees[i][j] += (A.donnees[i][k] * B.donnees[k][j]);
		return C;
	}
	
	// Multiplication de 2 matrices avec l'algorithme de Strassen
	public static Matrice strassen(Matrice A, Matrice B, int ls) {
		// On utilise une matrice d'ordre n avec n une puissance de 2 premièrement, puis on "enlève" les colonnes et lignes supperflus
		int n = A.n;
	    int m = prochainePuissanceDeDeux(n);
	    Matrice APrep = new Matrice(m);
	    Matrice BPrep = new Matrice(m);
	    APrep.remplissage();
	    BPrep.remplissage();
	    for (int i=0; i<n; i++) {
	        for (int j=0; j<n; j++) {
	            APrep.donnees[i][j] = A.donnees[i][j];
	            BPrep.donnees[i][j] = B.donnees[i][j];
	        }
	    }
	    
	    Matrice CPrep = strassenR(APrep, BPrep, ls);
	    Matrice C = new Matrice(n);
	    for (int i=0; i<n; i++) {
	        for (int j=0; j<n; j++) {
	            C.donnees[i][j] = CPrep.donnees[i][j];
	        }
	    }
	    return C;
	}
	
	// Algorithme de Strassen partant du principe que A et B sont deux matrices carrées d'ordre n avec n une puissance de 2
	public static Matrice strassenR(Matrice A, Matrice B, int ls) {
		if(A.n != B.n) throw new RuntimeException("Impossible de multiplier deux matrices de dimensions différentes.");
		int n = A.n;
		if (n <= ls) return multiplier(A, B);
		
		// Nouvelles matrices d'ordre n/2
		int m = n/2; 
		Matrice a11 = new Matrice(m);
		Matrice a12 = new Matrice(m);
		Matrice a21 = new Matrice(m);
		Matrice a22 = new Matrice(m);
		Matrice b11 = new Matrice(m);
		Matrice b12 = new Matrice(m);
		Matrice b21 = new Matrice(m);
		Matrice b22 = new Matrice(m);
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<m; j++) {
				a11.donnees[i][j] = A.donnees[i][j];
				a12.donnees[i][j] = A.donnees[i][j+m];
				a21.donnees[i][j] = A.donnees[i+m][j];
				a22.donnees[i][j] = A.donnees[i+m][j+m];
				b11.donnees[i][j] = B.donnees[i][j];
				b12.donnees[i][j] = B.donnees[i][j+m];
				b21.donnees[i][j] = B.donnees[i+m][j];
				b22.donnees[i][j] = B.donnees[i+m][j+m];
			}
		}
		
		// Algorithme de Strassen + récursivité
		Matrice e1 = strassenR(additionner(a11, a22), additionner(b11, b22), ls);
		Matrice e2 = strassenR(additionner(a21, a22), b11, ls);
		Matrice e3 = strassenR(a11, soustraire(b12, b22), ls);
		Matrice e4 = strassenR(a22, soustraire(b21, b11), ls);
		Matrice e5 = strassenR(additionner(a11, a12), b22, ls);
		Matrice e6 = strassenR(soustraire(a21, a11), additionner(b11, b12), ls);
		Matrice e7 = strassenR(soustraire(a12, a22), additionner(b21, b22), ls);
		
		Matrice c11 = additionner(additionner(e1, e4), soustraire(e7, e5));
		Matrice c12 = additionner(e3, e5);
		Matrice c21 = additionner(e2, e4);
		Matrice c22 = additionner(additionner(e1, e3), soustraire(e6, e2));
		
		// Regroupement de C
		Matrice C = new Matrice(n);
		for (int i=0; i<m; i++) {
			for (int j=0; j<m; j++) {
				C.donnees[i][j] = c11.donnees[i][j];
				C.donnees[i][j+m] = c12.donnees[i][j];
                C.donnees[i+m][j] = c21.donnees[i][j];
                C.donnees[i+m][j+m] = c22.donnees[i][j];
			}
		}
		return C;
	}
	
	// Remplissage d'une matrice avec des 0
	public void remplissage() {
		for (int i=0; i<n; i++) {
		    for (int j=0; j<n; j++) {
		        this.donnees[i][j] = 0;
		    }
		}
	}
	
	// Remplissage d'une matrice de façon aléatoire
	public void remplissageAleatoire() {
		Random random = new Random();
		for (int i=0; i<n; i++) {
		    for (int j=0; j<n; j++) {
		        this.donnees[i][j] = random.nextInt();
		    }
		}
	}
	
	// Test d'égalité entre 2 matrices
	public static boolean egales(Matrice A, Matrice B) {
        if (A.n != B.n) throw new RuntimeException("Impossible de tester l'égalité de deux matrices de dimensions différentes.");
        int n = A.n;
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (A.donnees[i][j] != B.donnees[i][j]) return false;
        return true;
	}
	
	// Affichage d'une matrice
	public void affichage() {
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                System.out.printf("%d ", donnees[i][j]);
            System.out.println();
        }
		System.out.println();
	}
	
	// Fonction calculant la prochaine puissance de 2 correspondant à un nombre
	private static int prochainePuissanceDeDeux(int n) {
	    int log2 = (int) Math.ceil(Math.log(n) / Math.log(2));
	    return (int) Math.pow(2, log2);
	}
}

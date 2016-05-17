package tri;

public class Debug {

	public static void main(String[] args) {
		int[] db = {58, 956, 4, 2, 3, 58, 42 ,54, 5, 214, 129, 536, 6, 59};
		db = TriBase.triBase(db);
		System.out.println(Integer.MAX_VALUE);
		for (int i=0; i<db.length; i++)
			System.out.print(db[i] + " ");
	}

}

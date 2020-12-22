package Test;

/**
 * This {@code IntArrays} class provides methods for manipulating {@code int}
 * arrays.
 * 
 * @author Quincy Asemota
 */
public class IntArrays {
	/**
	 * Returns a string representation of the contents of the specified array.
	 * 
	 * @param a an {@code int} array.
	 * @return a string representation of the contents of the specified array
	 */

	public static String toString(int[] a) {
		// Problem 2
		if (a == null) {
			return "()";
		}
		String s = "(";
		for (int i = 0; i < a.length; i++) {
			s += a[i];
			if (i != a.length - 1) {
				s += ",";
			}
		}
		s += ")";
		return s;

	}

	/**
	 * Determines whether or not the specified arrays have the same contents.
	 * 
	 * @param a1 an {@code int} array.
	 * @param a2 an {@code int} array.
	 * @return {@code true} if the specified arrays are of the same length and have
	 *         the same elements; {@code false} otherwise.
	 */
	// Problem 3
	public static boolean compare(int[] a1, int[] a2) {
		if (a1 == null || a2 == null)
			return a1 == a2;
		if (a1.length == a2.length) {
			for (int i = 0; i < a1.length; i++) {
				if (a1[i] != a2[i]) {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	/**
	 * Returns the concatenation of the two specified arrays.
	 * 
	 * @param a1 an {@code int} array.
	 * @param a2 an {@code int} array.
	 * @return an array that corresponds to the concatenation of the two specified
	 *         arrays.
	 */
	// Problem 4
	public static int[] concatenate(int[] a1, int[] a2) {
		if (a1 == null)
			return a2;
		if (a2 == null)
			return a1;
		int[] arr = new int[a1.length + a2.length];
		int ind = 0;
		for (int i = 0; i < a1.length; ++i) {
			arr[ind++] = a1[i];
		}
		for (int i = 0; i < a2.length; ++i) {
			arr[ind++] = a2[i];

		}
		return arr;
	}

	/**
	 * Merges two sorted arrays into a sorted array.
	 * 
	 * @param a1 a sorted {@code int} array.
	 * @param a2 a sorted {@code int} array.
	 * @return a sorted array containing the elements from the specified sorted
	 *         arrays.
	 */
	// Problem 5
	public static int[] merge(int[] a1, int[] a2) {
		if (a1 == null)
			return a2;
		if (a2 == null)
			return a1;
		int[] result = new int[a1.length + a2.length];
		int i = 0, j = 0, index = 0;
		while (i < a1.length || j < a2.length) {
			if (i < a1.length && (j >= a2.length || a1[i] <= a2[j])) {
				result[index++] = a1[i++];
			} else {
				result[index++] = a2[j++];
			}
		}
		return result;
	}

	/**
	 * The main function.
	 * 
	 * @param args the program arguments.
	 */
	public static void main(String[] args) {
		testToString();
		testCompare();
		testConcatenate();
		testMerge();
	}

	private static void testToString() {
		System.out.println(toString(new int[] { 1, 2, 3 }));
		System.out.println(toString(new int[] {}));
		System.out.println(toString(null));
	}

	private static void testCompare() {
		System.out.println(compare(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }));
		System.out.println(compare(new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 }));
		System.out.println(compare(new int[] { 1, 2, 3 }, new int[] { 1, 2 }));
		System.out.println(compare(new int[] { 1, 2, 3 }, null));
		System.out.println(compare(null, null));
	}

	private static void testConcatenate() {
		System.out.println(toString(concatenate(new int[] { 1, 2, 3 }, new int[] { 1, 3 })));
		System.out.println(toString(concatenate(new int[] { 1, 2, 3 }, null)));
		System.out.println(toString(concatenate(null, null)));
	}

	private static void testMerge() {
		System.out.println(toString(merge(new int[] { 1, 2, 3 }, new int[] { 1, 3 })));
		System.out.println(toString(merge(new int[] { 1, 2, 3 }, null)));
		System.out.println(toString(merge(null, null)));
	}

}

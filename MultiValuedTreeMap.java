package csi405.homework.hw04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * A {@code MultiValuedTreeMap} associates each key with a set of values.
 * 
 * @author Quincy Asemota CSI405
 * @param <K> the type of keys.
 * @param <V> the type of values.
 */
public class MultiValuedTreeMap<K, V> extends TreeMap<K, LinkedList<V>> implements Iterable<Pair<K, V>> {

	/**
	 * An automatically generated serial version ID.
	 */
	private static final long serialVersionUID = -6229569372944782075L;

	/**
	 * Adds the specified key and value.
	 * 
	 * @param k the key to add.
	 * @param v the value to add.
	 */
	public void add(K k, V v) {
		// Problem 1
		if (!containsKey(k)) {
			put(k, new LinkedList<V>());
		}

		get(k).add(v);

	}

	/**
	 * Removes the first value associated with the specified key.
	 * 
	 * @param k a key.
	 * @return the first value associated with the specified key; {@code null} if no
	 *         such value.
	 */
	public V removeFirst(K k) {
		// Problem 2
		if (!containsKey(k)) {
			return null;
		}

		V value = get(k).removeFirst();
		if (get(k).isEmpty()) {
			super.remove(k);
		}

		return value;
	}

	/**
	 * Removes the first value associated with the first key.
	 * 
	 * @return a {@code Pair} containing the first key and its first value;
	 *         {@code null} if this {@code MultiValuedTreeMap} is empty.
	 */
	public Pair<K, V> removeFirst() { 
		// Problem 3
		if (isEmpty()) {
			return null;
			}
			
		K k = firstKey();
			V v = removeFirst(k);
			Pair<K, V> p = new Pair<K, V>(k, v);
			return p;
		}
	
	/**
	 * Returns an iterator over the key-value pairs contained in this
	 * {@code MultiValuedTreeMap}.
	 * 
	 * @return an iterator over the key-value pairs contained in this
	 *         {@code MultiValuedTreeMap}.
	 */
	public Iterator<Pair<K, V>> iterator() { 
		// Problem 6
		ArrayList<Pair<K, V>> list = new ArrayList<Pair<K, V>>();
		for (K k : keySet()) {
			for (V v : get(k)) {
				list.add(new Pair<K, V>(k, v));
			}
		}
		return list.iterator();
	}

	/**
	 * The main method.
	 * 
	 * @param args the program arguments.
	 */
	public static void main(String[] args) {
		MultiValuedTreeMap<Integer, String> m = new MultiValuedTreeMap<Integer, String>();
		m.add(1, "b");
		m.add(1, "a");
		m.add(0, "c");
		System.out.println(m);

		System.out.println(m.removeFirst(1));
		System.out.println(m);
		System.out.println(m.removeFirst());
		System.out.println(m.removeFirst());
		System.out.println(m.removeFirst());

		m.add(1, "b");
		m.add(1, "a");
		m.add(0, "c");
		System.out.println(m);
		for (Pair<Integer, String> p : m) {
			System.out.println(p);
		}
	}
}

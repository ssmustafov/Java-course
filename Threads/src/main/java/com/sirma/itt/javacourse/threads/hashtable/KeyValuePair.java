package com.sirma.itt.javacourse.threads.hashtable;

/**
 * Interface for structure that maps keys to values.
 * 
 * @param <K>
 *            - type of the keys
 * @param <V>
 *            - type of the values
 * @author Sinan
 */
public interface KeyValuePair<K, V> {
	/**
	 * Maps the specified key to the specified value.
	 * 
	 * @param key
	 *            - the key
	 * @param value
	 *            - the value
	 * @return
	 */
	void put(K key, V value);

	/**
	 * Returns the value to which the specified key is mapped, or {@code null} if a structure
	 * contains no mapping for the key.
	 * 
	 * @param key
	 *            - the key that value will be returned
	 * @return - the value of the specified key
	 */
	V get(K key);

	/**
	 * Removes the key (and its corresponding value) from a structure that maps keys to values. This
	 * method does nothing if the key is not in the structure.
	 * 
	 * @param key
	 *            - the key that needs to be removed
	 */
	void remove(K key);
}

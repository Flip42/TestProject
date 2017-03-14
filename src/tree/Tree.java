package tree;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This Class implements the Interface java.util.Map in a minimalistic manor
 * 
 * @author Flip42
 *
 * @param <K>
 *            Key of Map
 * @param <V>
 *            stored Values
 */
public class Tree<K extends Comparable<K>, V> implements Map<K, V> {

	private Tree<K, V> left;
	private Tree<K, V> right;
	private Entry<K, V> entry;
	private int organizeCounter;

	public Tree(K key, V value) {
		this.entry = new Entry<K, V>(key, value);
		this.left = null;
		this.right = null;
		this.organizeCounter = 0;
	}

	public Tree() {
		this.entry = null;
		this.left = null;
		this.right = null;
		this.organizeCounter = 0;
	}

	@Override
	public int size() {
		int retval = (entry != null) ? 1 : 0;
		if (left != null) {
			retval += left.size();
		}
		if (right != null) {
			retval += right.size();
		}
		return retval;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	@Override
	public boolean containsValue(Object value) {
		if (entry != null && entry.value.equals(value)) {
			return true;
		}
		boolean retval = false;
		if (left != null) {
			retval = left.containsValue(value);
		}
		if (right != null && retval == false) {
			retval = right.containsValue(value);
		}
		return retval;

	}

	@Override
	public V get(Object key) {
		if (getElement(key) != null) {
			return getElement(key).entry.getValue();
		}
		return null;
	}

	private Tree<K, V> getElement(Object key) {
		if (entry == null) {
			return null;
		}
		if (entry.key.equals(key)) {
			return this;
		} else {
			if (entry.compareTo((K) key) >= 0) {
				if (left != null) {
					return left.getElement(key);
				}
				return null;
			} else {
				if (right != null) {
					return right.getElement(key);
				}
				return null;
			}
		}
	}

	@Override
	public V put(K key, V value) {
		if (entry == null) {
			entry = new Entry<K, V>((K) key, (V) value);
			return value;
		}
		if (entry.compareTo(key) >= 0) {
			if (left == null) {
				left = new Tree<K, V>();
			}
			left.put(key, value);
		} else {
			if (right == null) {
				right = new Tree<K, V>();
			}
			right.put(key, value);
		}
		organize();
		return (V) value;
	}

	@Override
	public V remove(Object key) {
		V value = null;
		Tree<K, V> element = getElement(key);
		if (element != null) {
			value = element.entry.getValue();
			element.entry = null;
			Tree<K, V> tmpLeft = element.left;
			Tree<K, V> tmpRight = element.right;
			element.left = element.right = null;
			element.putAll(tmpRight);
			element.putAll(tmpLeft);
		}
		return value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		if (map != null) {
			for (Map.Entry<? extends K, ? extends V> e : map.entrySet()) {
				this.put(e.getKey(), e.getValue());
			}
		}
	}

	@Override
	public void clear() {
		left = null;
		right = null;
		entry = null;
		organizeCounter = 0;
	}

	/**
	 * balances the Tree at every 10th Change
	 */
	private void organize() {
		organizeCounter++;
		if (organizeCounter > 10) {
			if (left != null) {
				left = left.balance();
			}
			if (right != null) {
				right = right.balance();
			}
		}
	}

	// see for further Info http://me-lrt.de/08-avl-baum-java-selbstbalanciert
	public Tree<K, V> balance() {
		Tree<K, V> root = this;
		int leftSize = 0;
		int rightSize = 0;
		if (left != null) {
			left = left.balance();
			leftSize = left.size();
		}
		if (right != null) {
			right = right.balance();
			rightSize = right.size();
		}
		if (leftSize + 1 < rightSize) {
			// Gegen den Uhrzeigersinn drehen
			if (right != null) {
				Tree<K, V> temp = right.left;
				right.left = this;
				root = this.right;
				this.right = temp;
				return root;
			}
		} else if (leftSize > rightSize + 1) {
			// Im Uhrzeigersinn drehen
			if (left != null) {
				Tree<K, V> temp = left.right;
				left.right = this;
				root = this.left;
				this.left = temp;
				return root;
			}
		}
		organizeCounter = 0;
		return root;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		set.add(entry.key);
		if (left != null) {
			set.addAll(left.keySet());
		}
		if (right != null) {
			set.addAll(right.keySet());
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		Set<V> set = new HashSet<V>();
		set.add(entry.value);
		if (left != null) {
			set.addAll(left.values());
		}
		if (right != null) {
			set.addAll(right.values());
		}
		return set;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		set.add(entry);
		if (left != null) {
			set.addAll(left.entrySet());
		}
		if (right != null) {
			set.addAll(right.entrySet());
		}
		return set;
	}

	public class Entry<K extends Comparable<K>, V> implements Map.Entry<K, V>, Comparable<K> {

		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		@Override
		public int compareTo(K o) {
			return this.key.compareTo(o);
		}

		public int compareTo(Entry<K, V> o) {
			return this.key.compareTo(o.getKey());
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry<K, V> other = (Entry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		private Tree getOuterType() {
			return Tree.this;
		}

	}

}

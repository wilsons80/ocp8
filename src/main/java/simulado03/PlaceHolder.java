package simulado03;

public class PlaceHolder<K, V> { // 1
	private K k;
	private V v;

	public PlaceHolder(K k, V v) { // 2
		this.k = k;
		this.v = v;
	}

	public K getK() {
		return k;
	}

	public static <X> PlaceHolder<X, X> getDuplicateHolder(X x) { // 3
		return new PlaceHolder<X, X>(x, x); // 4
	}
}

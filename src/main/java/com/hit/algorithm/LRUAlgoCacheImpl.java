package com.hit.algorithm;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {

	 private LinkedHashMap<K,V> map;


	 public LRUAlgoCacheImpl(int capacity) {
			super(capacity);
			this.map = new LinkedHashMap<>();
		}

	@Override
	public V getElement(K key) {
	    V v = this.map.get(key);
	       if (v == null) return null;
	       else return v;
	       
	}

	@Override
	public V putElement(K key, V value) {
		V val=null;
	       if (this.map.containsKey(key)) {
	       	this.map.remove(key);
	       }else if (this.map.size() == this.getCapacity()) {
	           Map.Entry<K, V> entry = map.entrySet().iterator().next();
	           val = entry.getValue();
	           Iterator<K> itr = this.map.keySet().iterator();
	           itr.next();
	           itr.remove();   
	           
	       }
	       map.put(key, value);
	       
	       return val;
	}

	@Override
	public void removeElement(K key) {
		this.map.remove(key);
		
	}
	

}
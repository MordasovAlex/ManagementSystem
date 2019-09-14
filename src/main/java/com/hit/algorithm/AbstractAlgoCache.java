package com.hit.algorithm;

public abstract class AbstractAlgoCache <K,V> implements IAlgoCache<K,V> {
	
	private final int capacity;
	
	protected AbstractAlgoCache(int capacity ) {
		this.capacity=capacity;
	}
	public int getCapacity() {
		return capacity;
	}

}

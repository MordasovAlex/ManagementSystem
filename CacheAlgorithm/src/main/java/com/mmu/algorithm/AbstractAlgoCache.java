package com.mmu.algorithm;

public abstract class AbstractAlgoCache <K,V> extends java.lang.Object implements IAlgoCache<K,V> {
	
	public final int capacity;
	public AbstractAlgoCache(int capacity ) {
		this.capacity=capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
}

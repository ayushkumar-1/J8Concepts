package com.ds.stack;

public class BasicStack<X> {
	
	private X[] data;
	private int stackPointer;
	
	//constructor
	public BasicStack() {
		this.data = (X[]) new Object[1000];
		this.stackPointer = 0;
	}

	//push
	public void push(X item) {
		//check data array is full or not
		if(stackPointer == 1000) {
			throw new IllegalStateException("Stack is Full. No more data can be added");
		}
		
		data[stackPointer++] = item;	
	}
	
	//pop
	public X pop() {

		//pop data
		if(data[0] == null) {
			throw new IllegalStateException("The stack is empty.");
		}
		X temp = (X)data[stackPointer - 1];
		System.out.println("pointer: "+stackPointer);
		data[--stackPointer] = null;
		
		return temp;
	}
	
	//contains
	public boolean contains(X item) {
		int counter = 0;
		while(counter < stackPointer) {
			if(data[counter].equals(item)) {
				return true;
			}
			counter++;
		}
		return false;
	}
	
	//size
	public int size() {
		return this.stackPointer;
	}
	
	@Override
	public String toString() {
		
		StringBuilder strBuild = new StringBuilder();
		for(int i = 0; i < stackPointer; i++) {
			strBuild.append(data[i]);
			if(i+1 != stackPointer) {
				strBuild.append(",");
			}
		}
		
		return strBuild.toString();
		
		
	}
}

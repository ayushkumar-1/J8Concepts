package com.concepts.generics;

public class Generics {

	public static void main(String args[]){
	      Holder<Integer> numbers = new Holder<Integer>(10);
	      try {
		
	      numbers.add(101);		
	      numbers.add(102);
	      numbers.add(102);
	      numbers.add(102);
	      numbers.add(102);
	      numbers.add(102);
	      numbers.add(102);
	      numbers.add(102);
	      numbers.add(166);
	      numbers.add(22);
	      
	      } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      System.out.println("Get: " + numbers.get(9));
	    }
	
	public String testThis() {
		System.out.println("Hello Stranger!!!");
		return "Who are you?";
	}
}


class Holder<T>{
    private T[] contents;
    private int index = 0;
    public Holder(int size){
        //contents = new T[size]; //compiler error - generic array creation
        contents = (T[]) new Object[size]; //workaround - casting Object[] to generic Type
    }
  
    public void add(T content) throws Exception{
    	System.out.println(index);
    	while(index < contents.length && contents[index] != null) {
    		System.out.println("in while");
    		index++;
    	}
    	System.out.println("length: "+contents.length);
    	if(index > contents.length - 1) {
    		throw new Exception("exceeded the length");
    	}else {
    		contents[index] = content;
    	}
    }
  
    public T get(int index){
        return contents[index];
    }
}

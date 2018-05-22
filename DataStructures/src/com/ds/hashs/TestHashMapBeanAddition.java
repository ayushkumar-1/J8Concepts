package com.ds.hashs;

import java.util.HashMap;
import java.util.Map;

public class TestHashMapBeanAddition {
	
	public static void main(String[] args) {
		
		Map<Product, String> map = new HashMap<>();
		Product prod1 = new Product(1, "shampoo");
		Product prod2 = new Product(1, "shampoo");
		Product prod3 = new Product(1, "shampoo");
		
		map.put(prod1, "data");
		map.put(prod2, "data");
		map.put(prod3, "data");
		
		System.out.println(prod1.hashCode());
		System.out.println(prod2.hashCode());
		System.out.println(prod3.hashCode());
		
		System.out.println(map);
	}
	
	private static class Product {
		
		private int productId;
		private String prodDes;
		
		//Constructor
		public Product(int id, String description) {
			this.productId = id;
			this.prodDes = description;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProdDes() {
			return prodDes;
		}

		public void setProdDes(String prodDes) {
			this.prodDes = prodDes;
		}
		
		public int hashCode() {
			int hash = this.productId % 10;
			System.out.println("hash: "+hash);
			return productId;
		}
		
		/*public final boolean equals(Object obj) {
			if(obj instanceof Product && ((Product) obj).getProdDes() == this.prodDes) {
				System.out.println("true");
				return true;
			}
			return false;
		}*/
		
		
		
	}

}
